package cmu.youchun.lifeguide.controller;

import cmu.youchun.lifeguide.BusinessException;
import cmu.youchun.lifeguide.common.CommonRes;
import cmu.youchun.lifeguide.common.CommonUtil;
import cmu.youchun.lifeguide.common.EmBusinessError;
import cmu.youchun.lifeguide.form.LoginForm;
import cmu.youchun.lifeguide.form.RegisterForm;
import cmu.youchun.lifeguide.model.UserModel;
import cmu.youchun.lifeguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller("/user")
@RequestMapping("/user")
public class UserController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public ModelAndView index(){
        String userName = "youchun";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name",userName);
        return modelAndView;
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRes getUser(@RequestParam(name="id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if(userModel == null){
            //return CommonRes.create(new CommonError(EmBusinessError.NO_OBJECT_FOUND),"fail");
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
        }else{
            return CommonRes.create(userModel);
        }
    }

    /**
     * Register a user.
     * @param registerForm
     * @param bindingResult
     * @return
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @PostMapping("/register")
    @ResponseBody
    public CommonRes register(@Valid @RequestBody RegisterForm registerForm, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        UserModel registerUser = new UserModel();
        registerUser.setPhone(registerForm.getPhone());
        registerUser.setPassword(registerForm.getPassword());
        registerUser.setNickName(registerForm.getNickName());
        registerUser.setGender(registerForm.getGender());


        UserModel resUserModel = userService.register(registerUser);

        return CommonRes.create(resUserModel);
    }

    /**
     * User login.
     * @param loginForm
     * @param bindingResult
     * @return
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @PostMapping("/login")
    @ResponseBody
    public CommonRes login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginForm.getPhone(),loginForm.getPassword());
        // put the user into httpSession
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION,userModel);

        return CommonRes.create(userModel);
    }

    /**
     * User logout
     * @return
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("/logout")
    @ResponseBody
    public CommonRes logout() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        httpServletRequest.getSession().invalidate();
        return CommonRes.create(null);
    }

    /**
     * Get current user information
     * @return
     */
    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public CommonRes getCurrentUser(){
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonRes.create(userModel);
    }

}
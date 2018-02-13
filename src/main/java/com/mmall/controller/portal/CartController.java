package com.mmall.controller.portal;


import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICartService;
import com.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;


    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.list(user.getId());
    }


    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session,
                                      Integer count, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.add(user.getId(), productId, count);
    }


    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<CartVo> update(HttpSession session,
                                      Integer count, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.update(user.getId(), productId, count);
    }


    @RequestMapping("delete_product.do")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(HttpSession session,
                                                String productIds){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.deleteProduct(user.getId(), productIds);
    }


    //全选，全反选；单独选，单独反选；
    // 查询当前用户购物车内产品数量，如果一个产品有十个，那么数量就是10


    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.selectOrUnselect(user.getId(), Const.Cart.CHECKED, null);
    }


    @RequestMapping("un_select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.selectOrUnselect(user.getId(), Const.Cart.UN_CHECKED, null);
    }


    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<CartVo> select(HttpSession session, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.selectOrUnselect(user.getId(), Const.Cart.CHECKED, productId);
    }


    @RequestMapping("un_select.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession session, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(
                    ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iCartService.selectOrUnselect(user.getId(), Const.Cart.UN_CHECKED, productId);
    }


    //获取当前用户的购物车产品数量

    @RequestMapping("get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENTUSER);
        if(user == null){
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }





}





















package com.yl.androidutils.utils.rxbase;

import com.dawei.okmaster.common.HttpRespond;
import com.dawei.okmaster.model.AdBean;
import com.dawei.okmaster.model.CaptChaBean;
import com.dawei.okmaster.model.CategoryBean;
import com.dawei.okmaster.model.CreateOrderResBean;
import com.dawei.okmaster.model.GoodsClassBean;
import com.dawei.okmaster.model.IntegralGoodsBean;
import com.dawei.okmaster.model.IntegralGoodsInfoBean;
import com.dawei.okmaster.model.NavBean;
import com.dawei.okmaster.model.PicAdsBean;
import com.dawei.okmaster.model.PlateBean;
import com.dawei.okmaster.model.ProduceBean;
import com.dawei.okmaster.model.ProtocolBean;
import com.dawei.okmaster.model.ProvinceBean;
import com.dawei.okmaster.model.TimeStampBean;
import com.dawei.okmaster.model.UploadImgBean;
import com.dawei.okmaster.model.VerifyPwdBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/3/1.
 */

public interface ApiService {
    @POST(APIFactory.ORDER_DETAIL)
    Observable<HttpRespond<String>> requestOrderDetail(
            @Body RequestBody requestBody);

    @POST(APIFactory.GET_ADDRESS)
    Observable<HttpRespond<String>> getAddress(
            @Body RequestBody requestBody);

    @POST(APIFactory.DELETE_ADDRESS)
    Observable<HttpRespond> deleteAddresses(
            @Body RequestBody requestBody);

    @POST(APIFactory.DEFAULT_ADDRESS)
    Observable<HttpRespond> setDefaultAddresses(
            @Body RequestBody requestBody);

    @POST(APIFactory.INTEGRAL_ORDER_LIST)
    Observable<HttpRespond<String>> getIntegralOrderList(
            @Body RequestBody requestBody);

    @POST(APIFactory.GET_ADDRESSES)
    Observable<HttpRespond<String>> getAddresses(
            @Body RequestBody requestBody);

    @POST(APIFactory.SAVE_ADDRESS)
    Observable<HttpRespond> saveAddress(
            @Body RequestBody requestBody);

    @GET(APIFactory.PCD_URL)
    Observable<HttpRespond<List<ProvinceBean>>> getPcdInfo(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver);

    @POST(APIFactory.MODIFY_PSW)
    Observable<HttpRespond> modifyPsw(
            @Body RequestBody requestBody);

    @POST(APIFactory.EXIT_URL)
    Observable<HttpRespond> exitLogin(
            @Body RequestBody requestBody);

    @POST(APIFactory.MODIFY_USER_INFO)
    Observable<HttpRespond> modifySafeUserInfo(
            @Body RequestBody requestBody);

    @POST(APIFactory.UPLOAD_IMG)
    Observable<UploadImgBean> uploadImg(
            @Body MultipartBody partList);

    @POST(APIFactory.USER_INFO)
    Observable<HttpRespond<String>> getSafeUserInfo(
            @Body RequestBody requestBody);

    @GET(APIFactory.PROTOCOL_URL)
    Observable<HttpRespond<ProtocolBean>> getProtocol(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver,
            @Query("id") int id); // 1是关于我们  2 注册协议  3是版本介绍

    @GET(APIFactory.GOODS_CLASS)
    Observable<HttpRespond<List<GoodsClassBean>>> getGoodsClass(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver,
            @Query("num") int num);

    @GET(APIFactory.PIC_ADS)
    Observable<HttpRespond<PicAdsBean>> getPicAds(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver);

    @GET(APIFactory.RECOMMEND_GOODS)
    Observable<HttpRespond<List<ProduceBean>>> getRecommendGoods(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver,
            @Query("num") int num);

    @GET(APIFactory.NAV_CLASS)
    Observable<HttpRespond<List<NavBean>>> getNavClass(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver);

    @POST(APIFactory.LOGIN)
    Observable<HttpRespond> doLogin(
            @Body RequestBody requestBody);

    @GET(APIFactory.TIME_STAMP)
    Observable<HttpRespond<TimeStampBean>> getTime(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver);

    @GET(APIFactory.GOODS_LIST)
    Observable<HttpRespond<List<ProduceBean>>> getGoodsList(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver,
            @Query("classid") String classId,
            @Query("page") int page,
            @Query("rows") int rows,
            @Query("name") String keyWords,
            @Query("order") int order,  // order: 0综合 1 销量  2最新  3到手价 从大到小 4从小到大
            @Query("low") String low,
            @Query("high") String high,
            @Query("other") int other); // 1是优惠券 2是9.9包邮 其余传0

    @GET(APIFactory.CAPTCHA_URL)
    Observable<HttpRespond<CaptChaBean>> getCaptchaUrl(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver);

    @GET(APIFactory.BANNER_URL)
    Observable<HttpRespond<List<AdBean>>> getBanner(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver,
            @Query("aid") int id, // 分类id
            @Query("num") int num); // 显示的数量

    /**
     * @param client
     * @param packageName
     * @param ver
     * @param Mobile
     * @param type        1找回密码  2注册
     * @return
     */
    @GET(APIFactory.SMS_CODE)
    Observable<HttpRespond> sendSMSCode(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver,
            @Query("Mobile") String Mobile,
            @Query("type") String type,
            @Query("tcode") String captcha);

    /**
     * 首页获取商品分类
     *
     * @param client
     * @param packageName
     * @param ver
     * @return
     */
    @GET(APIFactory.GOODS_CATEGORY)
    Observable<HttpRespond<List<CategoryBean>>> getCategoryList(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver
    );

    @GET(APIFactory.GOODS_PLATE)
    Observable<HttpRespond<List<PlateBean>>> getPlateList(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver
    );

    @POST(APIFactory.RESET_PWD)
    Observable<HttpRespond> resetPwd(
            @Body RequestBody requestBody);

    @POST(APIFactory.FORGET_PWD)
    Observable<HttpRespond<VerifyPwdBean>> verifySmsCode(
            @Body RequestBody requestBody);

    @POST(APIFactory.REGISTER)
    Observable<HttpRespond> registerAccount(
            @Body RequestBody requestBody);

    @POST(APIFactory.RESET_PASS)
    Observable<HttpRespond> resetPassword(
            @Body RequestBody requestBody);


    @POST(APIFactory.INTEGRAL_GOODS_LIST)
    Observable<HttpRespond<List<IntegralGoodsBean>>> getIntegralGoodsList(
            @Body RequestBody requestBody);

    @POST(APIFactory.INTEGRAL_GOODS_INFO)
    Observable<HttpRespond<IntegralGoodsInfoBean>> getIntegralGoodsInfo(
            @Body RequestBody requestBody);

    @POST(APIFactory.CREATE_ORDER)
    Observable<HttpRespond<CreateOrderResBean>> createOrder(
            @Body RequestBody requestBody
    );


}

package org.zognf.auto.generator.athm;

import org.junit.Before;
import org.junit.Test;
import org.zongf.db.meta.mysql.config.DbConfig;
import org.zongf.auto.generator.athm.utils.AthmCodeCreatorUtil;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class AutoCodeTest {


    @Before
    public void setUp(){
        DbConfig instance = DbConfig.getInstance();

        instance.setHost("10.27.14.191");
        instance.setPort(3306);
        instance.setUsername("centos");
        instance.setPassword("niuhongmei_123_!@#");
    }

    @Test
    public void getAthmPOCode(){
        String schemaName = "tp_hotel_shop";
        String tabelName = "autohome_employee";
        String packageName = "com.autohome.travelplat.hotel.shop.service.base.bean";

        String athmPOCode = AthmCodeCreatorUtil.createPOCode(schemaName, tabelName, packageName);
        System.out.println(athmPOCode);
    }

    @Test
    public void getAthmPOSwagerDocCode(){
        String schemaName = "tp_hotel_shop";
        String tabelName = "autohome_employee";
        String packageName = "com.autohome.travelplat.hotel.shop.model.request.autohome.staff";

        String athmPOCode = AthmCodeCreatorUtil.createPOSwaggerCode(schemaName, tabelName, packageName);
        System.out.println(athmPOCode);
    }




}

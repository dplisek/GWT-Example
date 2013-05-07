/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.applications.server.service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp1.applications.server.dao.GMZadostDao;
import sp1.applications.shared.entity.GMZadost;

/**
 *
 * @author JakubPetr
 */
@Service
public class GMZadostService {

    @Autowired
    private GMZadostDao zadostDao;

    /**
     * Copy all fields for which user has write access.
     * 
     * Access right name -> "field_" + propertyName
     * 
     * @param defaultValues
     * @param newValues
     * @param accessRights 
     */
    public void fillEntity(GMZadost defaultValues, GMZadost newValues, HashMap<String, String> accessRights) {
        List<String> ignoreProperties = new ArrayList<String>(10);

        for (Field field : GMZadost.class.getFields()) {
            if (!"W".equals(accessRights.get("field_" + field.getName()))) {
                ignoreProperties.add(field.getName());
            }
        }

        BeanUtils.copyProperties(newValues, defaultValues, ignoreProperties.toArray(new String[ignoreProperties.size()]));
    }

    /**
     * @TODO: zmenaStavu should not be changed here
     *
     * @param zadost
     */
    @Transactional
    public void create(GMZadost zadost) {
        zadost.setZmenaStavu(new Timestamp(new java.util.Date().getTime()));
        zadostDao.create(zadost);
    }

    @Transactional
    public void update(GMZadost zadost) {
        zadostDao.update(zadost);
    }

    @Transactional
    public GMZadost get(int id) {
        return zadostDao.get(id);
    }

    @Transactional
    public List<GMZadost> filter(String jednaciCislo, String jednaciCisloZadatele, Date datumDoruceniOd, Date datumDoruceniDo) {
        return zadostDao.filter(jednaciCislo, jednaciCisloZadatele, datumDoruceniOd, datumDoruceniDo);
    }
}

package sp1.applications.server.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp1.applications.server.dao.GMZadostDao;
import sp1.applications.shared.entity.GMZadost;

/**
 *
 * @author JakubPetr
 */
@Service
public class GMZadostDaoImpl implements GMZadostDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void create(GMZadost zadost) {
        sessionFactory.getCurrentSession().save(zadost);
    }

    @Override
    public void update(GMZadost zadost) {
        sessionFactory.getCurrentSession().update(zadost);
    }

    @Override
    public GMZadost get(int id) {
        return (GMZadost) sessionFactory.
                getCurrentSession().
                get(GMZadost.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GMZadost> filter(String jednaciCislo, String jednaciCisloZadatele, Date datumDoruceniOd, Date datumDoruceniDo) {
        Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(GMZadost.class);
        
        if(jednaciCislo != null && !jednaciCislo.equals("")){
            createCriteria.add( Restrictions.like("jednaciCislo", jednaciCislo) );
        }
    
        if(jednaciCisloZadatele != null && !jednaciCisloZadatele.equals("")){
            createCriteria.add( Restrictions.like("jednaciCisloZadatele", jednaciCisloZadatele) );
        }
        
        if(datumDoruceniOd != null && datumDoruceniDo != null){
            createCriteria.add( Restrictions.between("datumDoruceni", datumDoruceniOd, datumDoruceniDo) );
        }
        
        return createCriteria.list();
    }
}

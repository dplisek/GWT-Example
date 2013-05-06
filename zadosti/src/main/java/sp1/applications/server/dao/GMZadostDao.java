package sp1.applications.server.dao;

import java.sql.Date;
import java.util.List;
import sp1.applications.server.entity.GMZadost;

/**
 *
 * @author JakubPetr
 */
public interface GMZadostDao {
    
    void create(GMZadost zadost);

    void update(GMZadost zadost);
    
    GMZadost get(int id);
    
    List<GMZadost> filter(String jednaciCislo, String jednaciCisloZadatele, Date datumDoruceniOd, Date datumDoruceniDo);
    
}

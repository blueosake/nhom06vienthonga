/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.UTIL.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author LAPTOP
 */
public class ThamSoDao {
    public static String LayDuongDanHinhAnh()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        String path = "";
        
        String hql = "SELECT duongDanHinhAnh FROM Thamso";
        Query query = session.createQuery(hql);
        path = query.list().get(0).toString();
        
        session.close();
        return path;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

import MODEL.POJO.Hang;

import MODEL.UTIL.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author LAPTOP
 */
public class HangDAO {
    public static List<Hang> LayHang()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Hang> list = null;        

        try {
            String hql = "FROM Hang WHERE tinhTrang = 0";
            Query query = session.createQuery(hql);
            //query.setInteger("tt", 0);
            list = query.list();
        } catch (Exception ex) {
            Logger.getLogger(HangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            session.close();
        }
        
        return list;
    }
    
    public static Hang LayHangTheoMa(String mh) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Hang h = (Hang) session.get(Hang.class, mh);

        session.close();

        return h;
    }
 
    public static List<Hang> LayHangTheoMaLoaiSanPham(String mlsp)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Hang> list = null;        

        try {
            String hql = "SELECT lsph.hang FROM Loaisanphamhang lsph WHERE maLoaiSanPham=:mlsp";
            Query query = session.createQuery(hql);
            query.setString("mlsp", mlsp);
            list = query.list();
        } catch (Exception ex) {
            Logger.getLogger(HangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            session.close();
        }
        
        return list;
    }
}

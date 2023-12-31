package Controller;

 
import BEAN.DanhMucBean;
import GUI.Saler.ThongTinNhanVien;
import GUI.ThuKho.QuanLyKiemHang;
import GUI.ThuKho.QuanLyPhieuNhap;
import GUI.ThuKho.QuanLyXuatHang;
import GUI.ThuKho.TrangChu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khang
 */
public class ThuKhoController {
    
    private JPanel root;
    private String kindSelected="";
    private List<DanhMucBean> listItem = null;

    public ThuKhoController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "ThongTinNhanVien";    
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChu());
        root.validate();
        root.repaint();
        
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for(DanhMucBean item: listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
    
        }
        
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent( String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
            switch (kind) {
                case "TrangChu":
                    node = new TrangChu();
                    break;
                case "QuanLyKiemHang":
                    node = new QuanLyKiemHang();
                    break;
                case "QuanLyPhieuNhap":
                    node = new QuanLyPhieuNhap();
                    break;
                case "ThongTinNhanVien":
                    node =  new ThongTinNhanVien();
                    break;
                case "QuanLyPhieuXuat":
                    node = new QuanLyXuatHang();
                    break;

                // more
                default:
                    break;
           }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackGround(kind);
            System.out.println("chay mouseClicked");
        }


         @Override
      public void mousePressed(MouseEvent e) {
          System.out.println("chay mousePressed");
           kindSelected = kind;
//           jpnItem.setBackground(new Color(0,0,0));
//           jlbItem.setBackground(new Color(0,0,0));
      }

      @Override
      public void mouseReleased(MouseEvent e) {
          System.out.println("chay mouseReleased");
         
      }

      @Override
      public void mouseEntered(MouseEvent e) {
          System.out.println("chay mouseEntered");
//          jpnItem.setBackground(new Color(38,84,108));
//          jlbItem.setBackground(new Color(38,84,108));
      }

      @Override
      public void mouseExited(MouseEvent e) {
          System.out.println("chay mouseExited");
          if (!kindSelected.equalsIgnoreCase(kind)) {
//                jpnItem.setBackground(new Color(67,138,174));
//                jlbItem.setBackground(new Color(67,138,174));
          }
      }
        
    }
    private void setChangeBackGround(String kind){
        for(DanhMucBean item: listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(38,84,108));
                item.getJlb().setBackground(new Color(38,84,108));
            } else{
                item.getJpn().setBackground(new Color(67,138,174));
                item.getJlb().setBackground(new Color(67,138,174));
            }
            
        }
        
    }
}



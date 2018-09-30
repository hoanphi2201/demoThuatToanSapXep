/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoThuatToanSapXep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author phixuanhoan
 */
public class mainForm extends javax.swing.JFrame {
    private Timer time_one;
    private Timer time_two;
    private int speed1 = 600;
    private int speed2 = 5;
    private JLabel[] arrLabel;
    private JButton[] arrayButton;
    
    private int xButton1, yButton1;
    private int xButton2, yButton2;
    
    private JButton btn1;
    private JButton btn2;
    private ArrayList arr = new ArrayList();
    private DefaultListModel dlmLsvThuatToan = new DefaultListModel();
    
    JRadioButton[] rdb;
    
    private int indexSelected = -1;
    
    //Khai báo các thuật toán sắp xếp
    //Thuật toán - ý tưởng thuật toán - code sắp tăng - code sắp giảm
    String[][] DanhSachThuatToan = {
                        {"Interchange Sort", 
                        "Xuất phát từ đầu dãy,tìm tất cả các cặp nghịch thế chứa phần tử này, triệt tiêu chúng bằng cách đổi phần tử này với phần tử tương ứng trong cặp nghịch thế .Lặp lại xử lý trên với các phần tử tiếp theo", 
                        "Sắp giảm :"
                        + "for(int i = 0; i < n - 1; i++) :"
                        + "{ :"
                        + "       for(int j = i + 1; j < n; j++) :"
                        + "       { :"
                        + "             if(a[i] < a[j]) :"
                        + "             { :"
                        + "                  Swap(a[i], a[j]); :"
                        + "             } :"
                        + "       } :"
                        + "} :",
                        "Sắp tăng :"
                        + "for(int i = 0; i < n - 1; i++) :"
                        + "{ :"
                        + "       for(int j = i + 1; j < n; j++) :"
                        + "       { :"
                        + "             if(a[i] > a[j]) :"
                        + "             { :"
                        + "                  Swap(a[i], a[j]); :"
                        + "             } :"
                        + "       } :"
                        + "} :"
                        },
                        {"Bubble Sort", 
                        "Xuất phát từ cuối dãy,đổi chỗ các cặp phần tử kế cận để đưa phần tử nhỏ hơn hoặc lớn hơn trong cặp phần tử đó về vị trí đúng đầu dãy hiện hành, sau đó sẽ không xét đến nó ở bước tiếp theo,do vậy ở lần xử lý thứ i sẽ có vị trí đầu dãy là i. Lặp lại xử lý trên cho đến khi không còn cặp phần tử nào để xét", 
                        "Sắp giảm :"
                        + "for(int i = 0; i < n - 1; i++) :"
                        + "{ :"
                        + "       for(int j = n - 1; j > i; j--) :"
                        + "       { :"
                        + "             if(a[j - 1] > a[j]) :"
                        + "             { :"
                        + "                  Swap(a[j], a[j - 1]); :"
                        + "             } :"
                        + "       } :"
                        + "} :",
                        "Sắp tăng :"
                        + "for(int i = 0; i < n - 1; i++) :"
                        + "{ :"
                        + "       for(int j = n - 1; j > i; j--) :"
                        + "       { :"
                        + "             if(a[j - 1] < a[j]) :"
                        + "             { :"
                        + "                  Swap(a[j], a[j - 1]); :"
                        + "             } :"
                        + "       } :"
                        + "} :",
                        },
                        {"Selection sort", 
                        "Chọn phần tử nhỏ nhất hoặc lớn nhất trong N phần tử trong dãy hiện hành. Đưa phần tử này về vị trí đầu dãy hiện hành. Xem dãy hiện hành chỉ còn N-1 phần tử của dãy hiện hành ban đầu. Bắt đầu từ vị trí thứ 2. Lặp lại quá trình trên cho dãy hiện hành... đến khi dãy hiện hành chỉ còn 1 phần tử", 
                        "Sắp giảm :"
                        + "int min, i, j; :"
                        + "for(i = 0; i < n - 1; i++) :"
                        + "{ :"
                        +  "      min = i; :"
                        + "       for(int j = i + 1; j < n; j++) :"
                        + "       { :"
                        + "             if(a[j] > a[min]) :"
                        + "             { :"
                        + "                   min = j; :"
                        + "                   Swap(a[min], a[i]); :"
                        + "             } :"
                        + "       } :"
                        + "} :",
                        "Sắp tăng :"
                        + "int min, i, j; :"
                        + "for(i = 0; i < n - 1; i++) :"
                        + "{ :"
                        +  "      min = i; :"
                        + "       for(int j = i + 1; j < n; j++) :"
                        + "       { :"
                        + "             if(a[j] < a[min]) :"
                        + "             { :"
                        + "                   min = j; :"
                        + "                   Swap(a[min], a[i]); :"
                        + "             } :"
                        + "       } :"
                        + "} :",
                        },
                        {"Insertion sort", 
                        "Chọn phần tử nhỏ nhất hoặc lớn nhất trong N phần tử trong dãy hiện hành. Đưa phần tử này về vị trí đầu dãy hiện hành. Xem dãy hiện hành chỉ còn N-1 phần tử của dãy hiện hành ban đầu. Bắt đầu từ vị trí thứ 2. Lặp lại quá trình trên cho dãy hiện hành... đến khi dãy hiện hành chỉ còn 1 phần tử", 
                        "Sắp giảm :"
                        + "int pos, i; :"
                        + "int x; :"
                        + "for(i = 1; i < n; i++) :"
                        + "{ :"
                        +  "      x = a[i]; pos = i - 1; :"
                        + "       while( pos >= 0 && x > a[pos]) :"
                        + "       { :"
                        + "             a[pos + 1] = a[pos]; :"
                        + "             pos-- :"
                        + "       } :"
                        + "       a[pos + 1] = x; :"
                        + "} :",
                        "Sắp tăng :"
                        + "int pos, i; :"
                        + "int x; :"
                        + "for(i = 1; i < n; i++) :"
                        + "{ :"
                        +  "      x = a[i]; pos = i - 1; :"
                        + "       while( pos >= 0 && x < a[pos]) :"
                        + "       { :"
                        + "             a[pos + 1] = a[pos]; :"
                        + "             pos-- :"
                        + "       } :"
                        + "       a[pos + 1] = x; :"
                        + "} :",
                        },
                        {"Bynary Insertion sort", 
                        "Cải tiến của giải thuật InsertionSort. Giải thuật chèn nhị phân cho phép giảm số lần so sánh, nhưng không làm giảm số lần dời chỗ", 
                        "Sắp giảm :"
                        + "int left, right,m, pos, i; :"
                        + "int x; :"
                        + "for(i = 1; i < n; i++) :"
                        + "{ :"
                        +  "      x = a[i]; left = 0; right = i - 1; :"
                        + "       while( left <= right ) :"
                        + "       { :"
                        + "             m = (left + right)/2; :"
                        + "             if(x > a[m]) right = m -1; :"
                        + "             else left = m + 1; :"
                        + "       } :"
                        + "       for(pos = i - 1; pos >= left; pos--) :"
                        + "             a[pos + 1] = a[pos]; :"
                        + "        a[left] = x; :"
                        + "} :",
                        "Sắp tăng :"
                        + "int left, right,m, pos, i; :"
                        + "int x; :"
                        + "for(i = 1; i < n; i++) :"
                        + "{ :"
                        +  "      x = a[i]; left = 0; right = i - 1; :"
                        + "       while( left <= right ) :"
                        + "       { :"
                        + "             m = (left + right)/2; :"
                        + "             if(x < a[m]) right = m -1; :"
                        + "             else left = m + 1; :"
                        + "       } :"
                        + "       for(pos = i - 1; pos >= left; pos--) :"
                        + "             a[pos + 1] = a[pos]; :"
                        + "        a[left] = x; :"
                        + "} :",
                        },
                        {"Shell sort", 
                        "Cải tiến phương pháp InsertionSort. Phân hoạch dãy thành các dãy con. Sắp xếp các dãy con theo phương pháp InsertionSort. Dùng phương pháp InsertionSort sắp xếp lại cả dãy . Tìm k bước với các khoảng cách chọn theo công thức h(i) = (h(i-1) - 1)/2 và h(k) = 1, k = lg(n)/lg(2) - 1.", 
                        "Sắp giảm :"
                        + "void ShellSort(int a[], int n, int h[], int k) :"
                        + "{ :"
                        + "       int step, i, pos, x, len; :"
                        + "       for(step = 0; step < k; step++) :"
                        + "       { :"
                        + "             len = h[step]; :"
                        + "             for(i = len; i < n; i++) :"
                        + "             { :"
                        + "                   x = a[i]; :"
                        + "                   pos = i - len; :"
                        + "                   while( x > a[pos] && pos >= 0); :"
                        + "                   { :"
                        + "                           a[pos + len] = a[pos]; :"
                        + "                           pos = pos - len; :"
                        + "                   } :"
                        + "             } :" 
                        + "       } :"
                        + "       a[pos + len] = x; :"
                        + "} :",
                        "Sắp tăng :"
                        + "void ShellSort(int a[], int n, int h[], int k) :"
                        + "{ :"
                        + "       int step, i, pos, x, len; :"
                        + "       for(step = 0; step < k; step++) :"
                        + "       { :"
                        + "             len = h[step]; :"
                        + "             for(i = len; i < n; i++) :"
                        + "             { :"
                        + "                   x = a[i]; :"
                        + "                   pos = i - len; :"
                        + "                   while( x > a[pos] && pos >= 0); :"
                        + "                   { :"
                        + "                           a[pos + len] = a[pos]; :"
                        + "                           pos = pos - len; :"
                        + "                   } :"
                        + "             } :" 
                        + "       } :"
                        + "       a[pos + len] = x; :"
                        + "} :",
                        },
                        {"Shaker sort", 
                        "Trong mỗi lần sắp xếp, duyệt mảng theo 2 lượt từ 2 phía khác nhau: \n-Lượt đi : đẩy phần tử nhỏ(lớn) về đầu mảng.\n-Lượt về : đẩy phần tử lớn(nhỏ) về cuối mảng. Ghi nhận lại những đoạn đã sắp xếp nhằm tiết kiệm các phép so sánh", 
                        "Sắp giảm :"
                        + "void ShakerSort(int a[], int n) :"
                        + "{ :"
                        + "       int j, left, right, k; :"
                        + "       left = 0; right = n - 1; k = n - 1; :"
                        + "       while( left < right ) :"
                        + "       { :"
                        + "             for( j = right; j > left; j--) :"
                        + "             { :"
                        + "                    if(a[j] > a[j - 1]) :"
                        + "                    { :"
                        + "                           Swap(a[j], a[j - 1]); :"
                        + "                           k = j; :"
                        + "                    }:"
                        + "             left = k; :"
                        + "             for( j = left; j < right; j++) :"
                        + "             { :"
                        + "                    if(a[j + 1] > a[j]) :"
                        + "                    { :"
                        + "                           Swap(a[j], a[j + 1]); :"
                        + "                           k = j; :"
                        + "                    }:" 
                        + "             }:"
                        + "             right = k; :"
                        + "       } :"
                        + "} :",
                        "Sắp tăng :"
                        + "void ShakerSort(int a[], int n) :"
                        + "{ :"
                        + "       int j, left, right, k; :"
                        + "       left = 0; right = n - 1; k = n - 1; :"
                        + "       while( left < right ) :"
                        + "       { :"
                        + "             for( j = right; j > left; j--) :"
                        + "             { :"
                        + "                    if(a[j] < a[j - 1]) :"
                        + "                    { :"
                        + "                           Swap(a[j], a[j - 1]); :"
                        + "                           k = j; :"
                        + "                    }:"
                        + "             left = k; :"
                        + "             for( j = left; j < right; j++) :"
                        + "             { :"
                        + "                    if(a[j + 1] < a[j]) :"
                        + "                    { :"
                        + "                           Swap(a[j], a[j + 1]); :"
                        + "                           k = j; :"
                        + "                    }:" 
                        + "             }:"
                        + "             right = k; :"
                        + "       } :"
                        + "} :",
                        },
                        {"Heap sort", 
                        "Trong mỗi lần sắp xếp, duyệt mảng theo 2 lượt từ 2 phía khác nhau: \n-Lượt đi : đẩy phần tử nhỏ(lớn) về đầu mảng.\n-Lượt về : đẩy phần tử lớn(nhỏ) về cuối mảng. Ghi nhận lại những đoạn đã sắp xếp nhằm tiết kiệm các phép so sánh", 
                        "Sắp giảm :"
                        + "void Shift(int a[], int l,int r) :"
                        + "{ :"
                        + "       int x, i, j; :"
                        + "       i = 1; j = 2*i + 1;; :"
                        + "       x = a[i]; :"
                        + "       while( j <= r ) :"
                        + "       { :"
                        + "              if(j < r) :"
                        + "                     if(a[j] > a[j + 1]) :"
                        + "                            j++; :"
                        + "              if(x > a[j]) :"
                        + "              { :"
                        + "                     a[i] = a[j]; :"
                        + "                     a[j] = x; :"
                        + "                     i = j; j = x*i + 1; :"
                        + "                     x = a[i]; :"
                        + "              } :"
                        + "              else return;"
                        + "        } :"
                        + "} :"
                        + "void createHeap(int a[], int n) :"
                        + "{ :"
                        + "        int l; :"
                        + "        l = n / 2 - 1; :"
                        + "        while(l >= 0) :"
                        + "        { :"
                        + "               Shift(a, l, n - 1); :"
                        + "               l = l - 1; :"
                        + "        }"
                        + "} :"
                        + "void heapSort(int a[], int n) :"
                        + "{ :"
                        + "      int r; :"
                        + "      createHeap(a, n); :"
                        + "      r = n - 1; :"
                        + "      while( r > 0) :"
                        + "      { :"
                        + "             Swap(a[0], a[r]); :"
                        + "             r--; :"
                        + "             if(r > 0) :"
                        + "             Shift(a, 0, r); :"
                        + "      } :"
                        + "} :",
                        "Sắp tăng :"
                        + "void Shift(int a[], int l,int r) :"
                        + "{ :"
                        + "       int x, i, j; :"
                        + "       i = 1; j = 2*i + 1;; :"
                        + "       x = a[i]; :"
                        + "       while( j <= r ) :"
                        + "       { :"
                        + "              if(j < r) :"
                        + "                     if(a[j] < a[j + 1]) :"
                        + "                            j++; :"
                        + "              if(x < a[j]) :"
                        + "              { :"
                        + "                     a[i] = a[j]; :"
                        + "                     a[j] = x; :"
                        + "                     i = j; j = x*i + 1; :"
                        + "                     x = a[i]; :"
                        + "              } :"
                        + "              else return;"
                        + "        } :"
                        + "} :"
                        + "void createHeap(int a[], int n) :"
                        + "{ :"
                        + "        int l; :"
                        + "        l = n / 2 - 1; :"
                        + "        while(l >= 0) :"
                        + "        { :"
                        + "               Shift(a, l, n - 1); :"
                        + "               l = l - 1; :"
                        + "        }"
                        + "} :"
                        + "void heapSort(int a[], int n) :"
                        + "{ :"
                        + "      int r; :"
                        + "      createHeap(a, n); :"
                        + "      r = n - 1; :"
                        + "      while( r > 0) :"
                        + "      { :"
                        + "             Swap(a[0], a[r]); :"
                        + "             r--; :"
                        + "             if(r > 0) :"
                        + "             Shift(a, 0, r); :"
                        + "      } :"
                        + "} :",
                        },
                        {"Quick sort", 
                        "Sắp xếp dãy a(1),a(2),...,a(n) dựa trên việc phân hoạch dãy ban đầu thành 3 phần :\n -Phần 1 : Gồm các phần tử có giá trị bé hơn x.\n -Phần 2 : Gồm các phần tử có giá trị bằng x.\n-Phần 3 : Gồm các phần tử có giá trị lớn hơn x \n(Với x là giá trị của một phần tử tùy ý trong dãy ban đầu)", 
                        "Sắp giảm :"
                        + "void Quick(int a[], int n, int left, int right) :"
                        + "{ :"
                        + "       int i, j, x; :"
                        + "       x = a[(left + right) / 2]; :"
                        + "       i = left; j = right; :"
                        + "       do :"
                        + "       { :"
                        + "             while(a[i] > x) :"
                        + "                 i++; :"
                        + "             while(x > a[j]) :"
                        + "                 j--; :"
                        + "             if(i <= j) :"
                        + "             { :"
                        + "                   Swap(a[i], a[j]); :"
                        + "                   i++; j--; :"
                        + "             } :"
                        + "       } while( i <= j); :"
                        + "       if(left < j) :"
                        + "             Qick(a,left, j); :"
                        + "       if( i < right) :"
                        + "             Quick(a,i,right); :"
                        + "} :",
                        "Sắp tăng :"
                        + "void Quick(int a[], int n, int left, int right) :"
                        + "{ :"
                        + "       int i, j, x; :"
                        + "       x = a[(left + right) / 2]; :"
                        + "       i = left; j = right; :"
                        + "       do :"
                        + "       { :"
                        + "             while(a[i] < x) :"
                        + "                 i++; :"
                        + "             while(x < a[j]) :"
                        + "                 j--; :"
                        + "             if(i <= j) :"
                        + "             { :"
                        + "                   Swap(a[i], a[j]); :"
                        + "                   i++; j--; :"
                        + "             } :"
                        + "       } while( i <= j); :"
                        + "       if(left < j) :"
                        + "             Qick(a,left, j); :"
                        + "       if( i < right) :"
                        + "             Quick(a,i,right); :"
                        + "} :",
                        },
                        };
    /**
     * Creates new form mainForm
     */
    
    public mainForm() {
        initComponents();
        this.setSize(1200, 771);
        this.setLocationRelativeTo(null);
        
        //Khai báo timer
        time_one = new Timer(speed1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSort();  
            }
        });
        time_two = new Timer(speed2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveTwoButton(btn1, btn2);
            }
        });
        lsvThuatToan.setSelectedIndex(0);
        //Slider
        slideSpeed.setMaximum(200);
        slideSpeed.setMinimum(150);
        speed2 = 50;
        slideSpeed.setValue(150);
        slideSpeed.setMajorTickSpacing(100);
        slideSpeed.setMinorTickSpacing(10);
        slideSpeed.setPaintTicks(true);
        slideSpeed.setPaintTrack(true);
        
        //area
        areaYTuong.setLineWrap(true);          
        areaYTuong.setWrapStyleWord(true); 
        areaYTuong.setEditable(false); 
        
        rdb = new JRadioButton[DanhSachThuatToan.length];
        ButtonGroup btnGroup = new ButtonGroup();
        //Load tên các thuật toán sắp xếp
        for(int k = 0; k < DanhSachThuatToan.length; k++){
            rdb[k] = new JRadioButton();
            rdb[k].setText(DanhSachThuatToan[k][0]);
            rdb[k].setName(DanhSachThuatToan[k][0]);
            if(k >= 5){
                rdb[k].setLocation(170, (k-5) * 30 + 30);
            }else{
                rdb[k].setLocation(10, k * 30 + 30);
            }
            rdb[k].setSize(150, 20);
            rdb[k].setFont(new Font("Arial", Font.PLAIN, 12));
            rdb[k].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CheckInRadioButton(e);
                }
            });
            btnGroup.add(rdb[k]);
            panelCheckBox.add(rdb[k]);
        }
        this.setSize(1201, 775);
        
    }
    /**
     * Enalbel all button
     */
    public void setFalseEnabledButon(){
        btnRandomNumber.setEnabled(false);
        btnHuyBo.setEnabled(false);
        btnDebug.setEnabled(false);
        btnHuyQuaTrinh.setEnabled(false);
        btnStartSort.setEnabled(false);
        btnNhap.setEnabled(false);
        rdbGiam.setEnabled(false);
    }
    public void setTrueEnabledButon(){
        btnRandomNumber.setEnabled(true);
        btnHuyBo.setEnabled(true);
        btnDebug.setEnabled(true);
        btnHuyQuaTrinh.setEnabled(true);
        btnStartSort.setEnabled(true);
        btnNhap.setEnabled(true);
        rdbGiam.setEnabled(true);
    }
    /**
     * Xác định phần tử được check
     */
    public void CheckInRadioButton(ActionEvent e) {
        if (arr.size() > 0) {
            Object c = (Object) e.getSource();
            JRadioButton rdbChecked;
            for (int x = 0; x < rdb.length; x++) {
                if (c == rdb[x]) {
                    rdbChecked = rdb[x];
                    indexSelected = x;
                }
            }
            areaYTuong.setText(DanhSachThuatToan[indexSelected][1]);
            //mặc định cho sắp xếp giảm
            rdbTang.setSelected(true);
            if (rdbTang.isSelected()) {
                dlmLsvThuatToan.clear();
                String[] temp;
                temp = DanhSachThuatToan[indexSelected][3].split(":");
                for (int i = 0; i < temp.length; i++) {
                    dlmLsvThuatToan.addElement(temp[i]);
                }
                lsvThuatToan.setModel(dlmLsvThuatToan);
            } else if (rdbGiam.isSelected()) {
                dlmLsvThuatToan.clear();
                String[] temp;
                temp = DanhSachThuatToan[indexSelected][2].split(":");
                for (int i = 0; i < temp.length; i++) {
                    dlmLsvThuatToan.addElement(temp[i]);
                }
                lsvThuatToan.setModel(dlmLsvThuatToan);
            }
            if (indexSelected == 0) {
                i = 0;
                j = 1;
            } else if (indexSelected == 1) {
                i = 0;
                j = arrayButton.length - 1;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nhập số phần tử trước !");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        groupRadio = new javax.swing.ButtonGroup();
        panelCheckBox = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelSort = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblYTuong = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaYTuong = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        slideSpeed = new javax.swing.JSlider();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnStartSort = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnDebug = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnRandomNumber = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnNhap = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        lblChuaSapXep = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rdbTang = new javax.swing.JRadioButton();
        rdbGiam = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnHuyQuaTrinh = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsvThuatToan = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        checkDebug = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRandom = new javax.swing.JMenuItem();
        itemInputTungSo = new javax.swing.JMenuItem();
        itemInputDaySo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCheckBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Các phương pháp sắp xếp : ");

        javax.swing.GroupLayout panelCheckBoxLayout = new javax.swing.GroupLayout(panelCheckBox);
        panelCheckBox.setLayout(panelCheckBoxLayout);
        panelCheckBoxLayout.setHorizontalGroup(
            panelCheckBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCheckBoxLayout.setVerticalGroup(
            panelCheckBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        panelSort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelSortLayout = new javax.swing.GroupLayout(panelSort);
        panelSort.setLayout(panelSortLayout);
        panelSortLayout.setHorizontalGroup(
            panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1164, Short.MAX_VALUE)
        );
        panelSortLayout.setVerticalGroup(
            panelSortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblYTuong.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblYTuong.setText("Ý tưởng thuật toán: ");

        areaYTuong.setColumns(20);
        areaYTuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        areaYTuong.setRows(5);
        jScrollPane2.setViewportView(areaYTuong);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblYTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblYTuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setText("Thay đổi tốc độ");

        slideSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideSpeedStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slideSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slideSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel9.setText("Quá trình sắp xếp");

        btnStartSort.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnStartSort.setText("Bắt dầu");
        btnStartSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartSortActionPerformed(evt);
            }
        });

        btnPause.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnPause.setText("Tạm dừng");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnDebug.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnDebug.setText("Debug");
        btnDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStartSort, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnDebug, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartSort)
                    .addComponent(btnPause)
                    .addComponent(btnDebug))
                .addContainerGap())
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setText("Reset dãy số");

        btnRandomNumber.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnRandomNumber.setText("Ngẫu nhiên");
        btnRandomNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomNumberActionPerformed(evt);
            }
        });

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel10.setText("Từ bàn phím");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel11.setText("Phần tử");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel12.setText("Bằng");

        btnNhap.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnNhap.setText("Nhập");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRandomNumber)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnRandomNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblChuaSapXep.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblChuaSapXep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChuaSapXep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChuaSapXep, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("Hướng sắp xếp");

        groupRadio.add(rdbTang);
        rdbTang.setText("Tăng");
        rdbTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTangActionPerformed(evt);
            }
        });

        groupRadio.add(rdbGiam);
        rdbGiam.setText("Giảm");
        rdbGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbGiamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rdbTang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbGiam)
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTang)
                    .addComponent(rdbGiam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setText("Chế độ huỷ");

        btnHuyQuaTrinh.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnHuyQuaTrinh.setText("Huỷ quá trình");
        btnHuyQuaTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyQuaTrinhActionPerformed(evt);
            }
        });

        btnHuyBo.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnHuyBo.setText("Huỷ bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHuyQuaTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyBo)
                    .addComponent(btnHuyQuaTrinh))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lsvThuatToan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(lsvThuatToan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("Chế độ Debug");

        checkDebug.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        checkDebug.setText("Từng bước");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkDebug, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkDebug, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setText("Khởi tạo");

        itemRandom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        itemRandom.setForeground(new java.awt.Color(0, 0, 153));
        itemRandom.setText("Ngẫu nhiên");
        itemRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRandomActionPerformed(evt);
            }
        });
        jMenu1.add(itemRandom);

        itemInputTungSo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        itemInputTungSo.setForeground(new java.awt.Color(0, 0, 153));
        itemInputTungSo.setText("Nhập từng số");
        itemInputTungSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInputTungSoActionPerformed(evt);
            }
        });
        jMenu1.add(itemInputTungSo);

        itemInputDaySo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        itemInputDaySo.setForeground(new java.awt.Color(0, 0, 153));
        itemInputDaySo.setText("Nhập dãy số");
        itemInputDaySo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInputDaySoActionPerformed(evt);
            }
        });
        jMenu1.add(itemInputDaySo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("     Tuỳ chọn");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("     Trạng thái");
        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(new javax.swing.border.MatteBorder(null));
        jMenu4.setText("    Giới thiệu");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /**
     * Lưu dữ các thuật toán sắp xếp
     */
    public void selectSort(){
        if(indexSelected == 0){
            if (rdbTang.isSelected()) {
                moveButtonInterchangeSort(true);
            } else {
                moveButtonInterchangeSort(false);
            }
        } else if(indexSelected == 1){
            if (rdbTang.isSelected()) {
                moveButtonInterchangeSort(true);
            } else {
                moveButtonInterchangeSort(false);
            }
        }
        
    }
    /**
     * Move đối với 2 button thuật toán interChang sort
     */
    int sizeButton = 45;    int i, j;
    int conditionTimer = 1;
    public void moveButtonInterchangeSort(boolean typeSort){
        //Reset các label index trên form
        for (int p = 0; p < panelSort.getComponentCount(); ++p) {
            if (panelSort.getComponent(p) instanceof JLabel && panelSort.getComponent(p).getName() != null
                    && panelSort.getComponent(p).getName().equals("index")) {
                panelSort.remove(panelSort.getComponent(p));
                p--;
                this.setSize(1200, 770);
            }
        }
        //Reset màu theo nguyên tác những phần tử nào đã đi qua thì cho màu xanh
        for (int k = 0; k < arrayButton.length; ++k) {
            if (k <= i) { //những số đã duyệt qua thì cho màu xanh
                arrayButton[k].setBackground(Color.GREEN);
            } else { //ngược lại cho lại như ban đầu
                arrayButton[k].setBackground(Color.red);
            }
            arrayButton[k].setForeground(Color.white);
        }
        //Bản chất timer đã là 1 vòng lặp. không thể bê cả thuật toán vào đây
        if (i == arrayButton.length - 1) {
            arrayButton[i].setBackground(Color.GREEN);
            arrayButton[i].setForeground(Color.white);
            time_one.stop();
            time_two.stop();
            JOptionPane.showMessageDialog(null, "Sắp xếp thành công !");
            setTrueEnabledButon();
        } else {
            //Giai đoạn 1 xác định được i =>button i tô màu  và selectedIndex = 3;
            if (conditionTimer == 1) {
                arrayButton[i].setBackground(Color.GREEN);
                lsvThuatToan.setSelectedIndex(1);
                conditionTimer = 2;
            } //Giai đoạn 2 xác định j => button j tô màu vàng
            else if (conditionTimer == 2) {
                arrayButton[j].setBackground(Color.YELLOW);
                arrayButton[j].setForeground(Color.BLACK);
                lsvThuatToan.setSelectedIndex(3);
                conditionTimer = 3;
            } //Giai đoạn 3 so sánh i và j cho 2 button nhấp nháy
            else if (conditionTimer == 3) {
                lsvThuatToan.setSelectedIndex(5);
                arrayButton[i].setBackground(Color.BLUE);
                arrayButton[j].setBackground(Color.BLUE);
                conditionTimer = 4;
            } //Giai đoạn 4 hoán vị nếu có
            else if (conditionTimer == 4) {
                //true tăng false giảm
                if (Integer.parseInt(arrayButton[i].getText()) > Integer.parseInt(arrayButton[j].getText()) == typeSort) { //Nếu thoả hoán vị
                    lsvThuatToan.setSelectedIndex(7);
                    //Trạng thái ban đầu của 2 button
                    xButton1 = arrayButton[i].getLocation().x;
                    yButton1 = arrayButton[i].getLocation().y;
                    xButton2 = arrayButton[j].getLocation().x;
                    yButton2 = arrayButton[j].getLocation().y;

                    //Khởi động timer
                    btn1 = arrayButton[i];
                    btn2 = arrayButton[j];

                    time_two.start();   //Khởi động quá trình di chuyển 2 buttont
                    time_one.stop();    //tạm thời dừng quá trình xác định cặp số
                    //Swap 2 số
                    //Thay đổi vị trí 2 button trong mảng
                    JButton tmp = arrayButton[i];
                    arrayButton[i] = arrayButton[j];
                    arrayButton[j] = tmp;
                    areaYTuong.append("Với i = " + i + " j = " + j + "thì dãy là: ");
                    for (int x = 0; x < arrayButton.length; x++) {
                        areaYTuong.append(arrayButton[x].getText() + "; ");
                    }
                    areaYTuong.append("\n");

                } else { //nếu không thoả thì tăng i và j để đến cặp số mới
                    if(indexSelected == 0){
                        j++;
                        if (j == arrayButton.length) {
                            i++;
                            j = i + 1;
                            conditionTimer = 1; //về lại giai đoạn tăng i
                            lsvThuatToan.setSelectedIndex(3);
                        } else {
                            conditionTimer = 2;
                            lsvThuatToan.setSelectedIndex(5);
                        }
                    }else if( indexSelected == 1){
                        j--;
                        if (j <= i) {
                            i++;
                            j = arr.size() - 1;
                            conditionTimer = 1; //về lại giai đoạn tăng i
                            lsvThuatToan.setSelectedIndex(3);
                        } else {
                            conditionTimer = 2;
                            lsvThuatToan.setSelectedIndex(5);
                        }
                    }
                   
                }

            }
            //Lỗi ở đây
            if (j < arrayButton.length) {
                JLabel label_index_i = new JLabel();
                label_index_i.setText("i = " + i);
                label_index_i.setSize(50, 50);
                label_index_i.setLocation(arrLabel[i].getLocation().x, arrLabel[i].getLocation().y - 40);
                label_index_i.setName("index");
                label_index_i.setFont(new Font("Arial", Font.PLAIN, 12));
                panelSort.add(label_index_i);

                JLabel label_index_j = new JLabel();
                label_index_j.setText("j = " + j);
                label_index_j.setSize(50, 50);
                label_index_j.setLocation(arrLabel[j].getLocation().x, arrLabel[j].getLocation().y - 40);
                label_index_j.setName("index");
                label_index_j.setFont(new Font("Arial", Font.PLAIN, 12));
                panelSort.add(label_index_j);
                this.setSize(1200, 771);
            }
            
        }

    }
    
    /**
     * Hàm tạo ra sự di chuyển của 2 button
     */
    public void moveTwoButton(JButton button1, JButton button2){
        //Bước 1 cả 2 nut button cùng đi lên và đi đến khi độ cao lớn hơn độ cao button
        if(yButton1 - button1.getLocation().y < button1.getSize().height && button1.getLocation().x != xButton2){
            button1.setLocation(button1.getLocation().x, button1.getLocation().y  - 1);
        }
        if(button2.getLocation().y -yButton2  < button2.getSize().height && button2.getLocation().x != xButton1){
            button2.setLocation(button2.getLocation().x, button2.getLocation().y  + 1);
        }
        // Bước 2 nut button phải qua trái, trái qua phải
        if(yButton1 - button1.getLocation().y == button1.getSize().height && button1.getLocation().x < xButton2){
            button1.setLocation(button1.getLocation().x + 1, button1.getLocation().y);
        }
        if(button2.getLocation().y -yButton2  == button2.getSize().height && button2.getLocation().x > xButton1){
            button2.setLocation(button2.getLocation().x - 1, button2.getLocation().y);
        }
        // Bước 3 đi xuống
        if(button1.getLocation().x == xButton2){
            button1.setLocation(button1.getLocation().x, button1.getLocation().y +1);
        }
        if(button2.getLocation().x == xButton1){
            button2.setLocation(button2.getLocation().x, button2.getLocation().y -1);
        }
        //Bước 4 hoàn tất
        if(xButton1 == button2.getLocation().x && button1.getLocation().y == yButton2){
            if(indexSelected == 0){
                j++;
                if(j == arrayButton.length){
                    i++;
                    j = i + 1;
                    conditionTimer = 1; //về lại giai đoạn tăng i
                    lsvThuatToan.setSelectedIndex(3);
                }else{
                    conditionTimer = 2;
                    lsvThuatToan.setSelectedIndex(5);
                }
                time_two.stop();   // Dừng quá trình di chuyển 1 button 
                //Chủ được gọi khi không ở chế độ debug từng bước
                if(checkDebug.isSelected() == false){
                    time_one.start();  //Tiếp tục quá trình tìm kiếm 2 số
                } 
            } else if(indexSelected == 1){
                j--;
                if(j <= i){
                    i++;
                    j = arr.size() - 1;
                    conditionTimer = 1; //về lại giai đoạn tăng i
                    lsvThuatToan.setSelectedIndex(3);
                }else{
                    conditionTimer = 2;
                    lsvThuatToan.setSelectedIndex(5);
                }
                time_two.stop();   // Dừng quá trình di chuyển 1 button 
                //Chủ được gọi khi không ở chế độ debug từng bước
                if(checkDebug.isSelected() == false){
                    time_one.start();  //Tiếp tục quá trình tìm kiếm 2 số
                } 
            }
            
        }
    }
    
    private void btnStartSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartSortActionPerformed

        if(indexSelected >= 0){
            if(arr.size() > 0){
                setFalseEnabledButon();
                time_one.start();
                areaYTuong.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Nhập các phần tử cho mảng !");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vui lòng chịn thuật toán sắp xếp !");
        }
               
    }//GEN-LAST:event_btnStartSortActionPerformed
    //Sự kiện debug từng bước
    private void btnDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebugActionPerformed
        if (checkDebug.isSelected() == true) { //đang chọn chế độ debug từng bước
            if (time_two.isRunning() == false) { //nếu như cái timer đổi chỗ 2 số mà không chạy thì mới cho click
                if (rdbTang.isSelected()) {
                    moveButtonInterchangeSort(true);
                } else {
                    moveButtonInterchangeSort(false);
                }
            } else if (indexSelected == 1) {

            }

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng check vào debug từng bước !");
        }
    }//GEN-LAST:event_btnDebugActionPerformed
    //Chức năng tạm dừng
    int countClickPause = 0;
    boolean check = true; //kiểm tra mối liên hệ giữa 2 timer
    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if(countClickPause == 0){ //start timer
            if(time_one.isRunning()){
                time_one.stop();
            }
            if(time_two.isRunning()){
                time_two.stop();
                check = false;
            }
            btnHuyBo.setEnabled(true);
            btnHuyQuaTrinh.setEnabled(true);
            btnPause.setText("Tiếp tục");
            countClickPause = 1;
        }else{
            //timer xác định cặp số chỉ được chạy khi timer đổi chỗ không hoạt động
            if(check == false){
                time_two.start();
            } else{
                time_one.start();
            }
            btnHuyBo.setEnabled(false);
            btnHuyQuaTrinh.setEnabled(false);
            btnPause.setText("Tạm dừng");
            countClickPause = 0;
            check = true;
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void slideSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideSpeedStateChanged
         try {
            time_two.setDelay(201 - slideSpeed.getValue());
        } catch (Exception e) {}
    }//GEN-LAST:event_slideSpeedStateChanged

    private void btnRandomNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomNumberActionPerformed
        i = 0; 
        j = 1; //reset lại để cho nó đổi chỗ
        panelSort.removeAll();
        this.setSize(1200, 771);
        this.setSize(1200, 775);
        lblChuaSapXep.setText("");
        arr.clear();
        try {
            String num;
            do {            
                num = JOptionPane.showInputDialog(null,"Nhập vào số phẩn tử muốn tạo !");
            } while (Integer.parseInt(num) > 20);
                int Num = Integer.parseInt(num);  
                arrayButton = new JButton[Num];
                arrLabel = new JLabel[Num];
                Random rd = new Random();
                for(int i = 0; i < Num; i++){
                    int temp = rd.nextInt(100);
                    insertNumberToButton(i, temp + "");
                    arr.add(temp);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Số phần tử không hợp lệ !", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRandomNumberActionPerformed

    private void itemInputTungSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInputTungSoActionPerformed
        i = 0; 
        j = 1; //reset lại để cho nó đổi chỗ
        panelSort.removeAll();
        this.setSize(1201, 771);
        lblChuaSapXep.setText("");
        arr.clear(); 
        try {
            String num;
            do {            
                num = JOptionPane.showInputDialog(null,"Nhập vào số phẩn tử muốn tạo !");
            } while (Integer.parseInt(num) > 20);
            int Num = Integer.parseInt(num);
            arrayButton = new JButton[Num];
            arrLabel = new JLabel[Num];
            for(int x = 0; x < Num; x++){
                this.setSize(1200, 771);
                String tmp = JOptionPane.showInputDialog(null,"Nhập vào phẩn tử thứ : " + (x + 1));
                insertNumberToButton(x, tmp);
                arr.add(tmp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Số phần tử không hợp lệ !", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itemInputTungSoActionPerformed

    private void itemRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRandomActionPerformed
        i = 0; 
        j = 1; //reset lại để cho nó đổi chỗ
        panelSort.removeAll();
        this.setSize(1200, 771);
        this.setSize(1200, 775);
        lblChuaSapXep.setText("");
        arr.clear();
        try {
            String num;
            do {            
                num = JOptionPane.showInputDialog(null,"Nhập vào số phẩn tử muốn tạo !");
            } while (Integer.parseInt(num) > 20);
                int Num = Integer.parseInt(num);  
                arrayButton = new JButton[Num];
                arrLabel = new JLabel[Num];
                Random rd = new Random();
                for(int i = 0; i < Num; i++){
                    int temp = rd.nextInt(100);
                    insertNumberToButton(i, temp + "");
                    arr.add(temp);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Số phần tử không hợp lệ !", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itemRandomActionPerformed
    public void insertNumberToButton(int vitri, String text){
        lblChuaSapXep.setText(lblChuaSapXep.getText() + "    " + text);
        arrayButton[vitri] = new JButton();
        arrayButton[vitri].setSize(sizeButton, sizeButton);
        arrayButton[vitri].setText(text);
        //Mỗi button cách nhau 10 và cách lề panel 30
        arrayButton[vitri].setLocation(((sizeButton + 10) * vitri) + 30, panelSort.getSize().height/2 - sizeButton/2);
        arrayButton[vitri].setBackground(Color.red);
        arrayButton[vitri].setForeground(Color.white);
        arrayButton[vitri].setFont(new Font("Arial", Font.PLAIN, 15));
           
        //Chỉ số bên dưới
        arrLabel[vitri] = new JLabel();
        arrLabel[vitri].setText(vitri+"");
        arrLabel[vitri].setLocation(arrayButton[vitri].getLocation().x + sizeButton/3, arrayButton[vitri].getLocation().y + 130);
        arrLabel[vitri].setSize(20,20);
        arrLabel[vitri].setFont(new Font("Arial", Font.PLAIN, 18));
        arrLabel[vitri].setName("tmp");
        panelSort.add(arrLabel[vitri]);
        panelSort.add(arrayButton[vitri]);
        this.setSize(1201, 771);
    }
    private void itemInputDaySoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInputDaySoActionPerformed
        i = 0; 
        j = 1; //reset lại để cho nó đổi chỗ
        panelSort.removeAll();
        this.setSize(1200, 771);
        this.setSize(1200, 775);
        lblChuaSapXep.setText("");
        arr.clear();
        String num = JOptionPane.showInputDialog(null,"Nhập vào dãy số !");
        String[] tmp = num.split(" ");
        ArrayList number = new ArrayList();
        for(String s : tmp){
            if(s.equals("") == false){
                try {
                    number.add(Integer.parseInt(s));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Dãy số không hợp lệ!");
                    break;
                }
            }
        }
        int N = number.size();
        arrayButton = new JButton[N];
        arrLabel = new JLabel[N];
        for(int  x = 0 ; x < N; x++){
            insertNumberToButton(x, number.get(x).toString());
            arr.add(number.get(x));
        }
    }//GEN-LAST:event_itemInputDaySoActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        arr.clear();
        panelSort.removeAll();
        this.setSize(1200,772);
        lblChuaSapXep.setText("");
        if(indexSelected == 0){
            i = 0; 
            j = 1; //reset lại để cho nó đổi chỗ
        }else if(indexSelected == 1){
            i = 0; 
            j = arr.size() -1; //reset lại để cho nó đổi chỗ
        }
        
    }//GEN-LAST:event_btnHuyBoActionPerformed
    
    
    private void rdbTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTangActionPerformed
        if(indexSelected >= 0){
            dlmLsvThuatToan.clear();
            String[] temp;
            temp = DanhSachThuatToan[indexSelected][3].split(":");
            for(int i = 0; i < temp.length; i++){
                dlmLsvThuatToan.addElement(temp[i]);
            }
            lsvThuatToan.setModel(dlmLsvThuatToan);
        }
        
    }//GEN-LAST:event_rdbTangActionPerformed

    private void rdbGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbGiamActionPerformed
        if(indexSelected >= 0){
            dlmLsvThuatToan.clear();
            String[] temp;
            temp = DanhSachThuatToan[indexSelected][2].split(":");
            for(int i = 0; i < temp.length; i++){
                dlmLsvThuatToan.addElement(temp[i]);
            }
            lsvThuatToan.setModel(dlmLsvThuatToan);
        }
    }//GEN-LAST:event_rdbGiamActionPerformed
    //Dãy số vẫn ở đó và quay lại như ban đầu
    private void btnHuyQuaTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyQuaTrinhActionPerformed
        setTrueEnabledButon();
        //Dừng 2 timer
        time_one.stop();
        time_two.stop();
        
        //Reset và add lại
        boolean checkReset = false;
        if(panelSort.getComponentCount() > 0){
            panelSort.removeAll();
            checkReset = true;
        }
        if(indexSelected == 0){
            i = 0; 
            j = 1; //reset lại để cho nó đổi chỗ
        }else if(indexSelected == 1){
            i = 0; 
            j = arr.size() -1; //reset lại để cho nó đổi chỗ
        }
        
        conditionTimer = 1;
        areaYTuong.setText("");
        lblChuaSapXep.setText("");
        if(checkReset == true){
            arrayButton = new JButton[arr.size()];
            arrLabel = new JLabel[arr.size()];
            for(int x = 0; x < arr.size(); x++){
                insertNumberToButton(x, arr.get(x).toString());
            }
        }
       
    }//GEN-LAST:event_btnHuyQuaTrinhActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaYTuong;
    private javax.swing.JButton btnDebug;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnHuyQuaTrinh;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnRandomNumber;
    private javax.swing.JButton btnStartSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkDebug;
    private javax.swing.ButtonGroup groupRadio;
    private javax.swing.JMenuItem itemInputDaySo;
    private javax.swing.JMenuItem itemInputTungSo;
    private javax.swing.JMenuItem itemRandom;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblChuaSapXep;
    private javax.swing.JLabel lblYTuong;
    private javax.swing.JList<String> lsvThuatToan;
    private javax.swing.JPanel panelCheckBox;
    private javax.swing.JPanel panelSort;
    private javax.swing.JRadioButton rdbGiam;
    private javax.swing.JRadioButton rdbTang;
    private javax.swing.JSlider slideSpeed;
    // End of variables declaration//GEN-END:variables
}

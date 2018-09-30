# demoThuatToanSapXep
1/ Giới thiệu phần mềm và phân tích ra các chức năng

Chức năng quan trọng nhất: Cách để diễn hoạt quá trình sắp xếp và Tương ứng diễn hoạt đó là dòng code nào sẽ chạy
	=> Có thể tạm dừng quá trình diễn hoạt để nhìn cho rõ hoặc có chế độ Debug từng bước
	=> Có thể thay đổi được tốc độ nhanh hay chậm
Chức năng bổ sung:
+ Có 2 chế độ nhập dữ liệu:
	1/ Nhập ngẫu nhiên => chỉ cần nhập vào số lượng phần tử muốn tạo thì sẽ xuất hiện đúng bấy nhiêu số lượng đó ngẫu nhiên
	2/ Nhập từ bàn phím => có 2 dạng: Nhập từng phần tử và nhập cả dãy số
	
	=> Tạo ra tương ứng các nút Button hiển thị số lên và ở dưới hiện ra dãy số index bắt đầu đánh từ 0 trở đi đến N - 1 (với N là 	số lượng phần tử)

+ Lựa chọn thuật toán sắp xếp tương ứng trong danh sách các thuật toán => Danh sách các RadioButton tương ứng với từng thuật toán

+ Luôn lưu lại hiện trạng dãy số thay đổi qua từng quá trình sắp xếp

+ Cho phép lựa chọn hướng sắp xếp tăng hay giảm => khi lựa chọn thì sẽ thay đổi code demo tương ứng tăng/giảm

+ Có 1 khung ý tưởng thuật toán để cho người sử dụng nắm được thông tin về thuật toán này

+ Reset tất cả về lại ban đầu => hủy bỏ quá trình sắp xếp nếu không còn nhu cầu ngay cả khi nó đang chạy hoặc hủy bỏ cả dãy số reset tất cả

2/xây dựng các chức năng

int[] arr = {1, 2, 3, 4, 5};

=> Tạo mảng động các Button có Text chính là giá trị các phần tử có trong mảng arr
	Button[] btn = new Button[arr.Count()];
	
	
=> Dưới mỗi Button sẽ có 1 Label là chỉ số index tương ứng => tạo động Label in lên Form => canh tọa độ Label luôn nằm dưới Button

+ Đối với chức năng chính (chỉ nói riêng về việc diễn hoạt quá trình sắp xếp chưa nói đến tương ứng dòng code chạy) thì có 2 giai đoạn xảy ra trong nó:
	=> Giai đoạn 1: Mô phỏng quá trình tìm cặp phần tử thỏa
	=> Giai đoạn 2: Khi tìm thấy phần tử thỏa điều kiện thì tiến hành đổi chỗ cho nhau
=> Và 2 giai đoạn này đều đúng với tất cả mọi thuật toán sắp xếp (đều chỉ là tìm ra cặp phần tử để so sánh và đổi chỗ nếu thỏa điều kiện)
Giai đoạn 2: có 2 nút Button làm sao cho cùng lúc 2 Button nó chạy lên chạy xuống rồi cái chạy qua trái, cái chạy qua phải rồi cùng nhau hạ xuống để hoàn tất quá trình đổi chỗ => Timer
Giai đoạn 1: Làm sao mô phỏng được quá trình tìm cặp phần tử thỏa?
=> Gợi ý:  (Vd: Interchange Sort) giả sử có 5 phần tử thì lần lượt nó sẽ so sánh các cặp:
0 - 1
0 - 2
0 - 3
0 - 4
1 - 2
1 - 3
1 - 4
2 - 3
2 - 4
3 - 4

Sau khi ra được danh sách các cặp số như trên, giả sử muốn có 1 hàm nhận vào 2 vị trí index theo thứ tự rồi với vị trí index đầu tiên tô màu xanh, index thứ 2 tô màu vàng
vd: ThayDoiMau(0, 1) => Button index = 0 màu xanh, Button index = 1 màu vàng
vd: ThayDoiMau(0, 2) => Button index = 0 màu xanh, Button index = 2 màu vàng

=> Biến nó thành quy trình tự động nhờ Timer để chạy hết tất cả các cặp số

Sau khi làm ra được hết 2 giai đoạn trên thì chúng ta kết hợp Giai đoạn 1 & Giai đoạn 2 lại làm 1 theo thứ tự và như thế là đã xong được việc diễn hoạt thuật toán qua 2 giai đoạn.
Còn 1 chức năng chính : "Tương ứng diễn hoạt đó là dòng code nào sẽ chạy"
=> Làm sao???
=> Nó sẽ chạy hiển thị ở bên kia tương ứng trước cho chúng ta thấy rồi sau đó bên phần diễn hoạt quá trình sắp xếp mới chạy tương ứng
=> Dùng Control JList bỏ đoạn source code sắp xếp vào và mỗi lần chạy đến dòng nào thì cho Selectedindex dòng đó
vòng for đầu tiên ở dòng 4 => selectedindex = 4
vòng for thứ 2 ở dòng 5
if ở dòng 6 (so sánh cặp phần tử)
swap ở dòng 7

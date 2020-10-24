create  database QL_Rap;
use QL_Rap;

create table taikhoan(
	id			int unique,
    taikhoan	nvarchar(50),
    matkhau		nvarchar(50),
    quyen		varchar(10),
    primary key(id)
);
insert into taikhoan (id,taikhoan,matkhau,quyen) values (1,N'nguyenlehai',N'hai','admin');
insert into taikhoan (id,taikhoan,matkhau,quyen) values (2,N'lehainguyen',N'hainguyen','user');
Select quyen from taikhoan where taikhoan=N'lehainguyen' and matkhau='hainguyen';



create table nhanvien(
	manv		char(20) unique,
    tennv		varchar(200),
    ngaysinh	datetime,
    gioitinh	varchar(20),
    quequan		varchar(300),
    sodienthoai	int(10),
    email		varchar(100),
    luong		float,
    primary key(manv)
);

insert into ql_rap.nhanvien(manv,tennv,ngaysinh,gioitinh,quequan,sodienthoai,email,luong) values ('MNV1','LeHai','01/02/20','Nam', 'SG', 0335351217, 'lehai@gmail.com', 50000000);
insert into ql_rap.nhanvien(manv,tennv,ngaysinh,gioitinh,quequan,sodienthoai,email,luong) values ('MNV2','ThePhuong','20/02/20','Nam', 'Long An', 03552558, 'thephuong@gmail.com', 30000000);


UPDATE ql_rap.nhanvien SET tennv='NguyeCongLinh' , ngaysinh='00/01/01', gioitinh= 'nam' , quequan ='Ca Mau' ,sodienthoai=0355116642,email='nguyenconglinh',luong=20000000 where manv='MNV2';
DELETE FROM ql_rap.nhanvien WHERE manv = 'MNV';
Select * from ql_rap.nhanvien;


create table ql_rap.hitiet_nhanvien_ve(
	mact	char(10),
	mave	char(20),
    manv	char(20),
    primary key(mact),
   FOREIGN KEY (mave) REFERENCES ve(mave),
   FOREIGN KEY (manv) REFERENCES nhanvien(manv)
);

create table ve(
	mave	char(20) unique,
    ngaybanve datetime,
    ngaychieu	datetime,
    giave		float,
    primary key(mave)
    );
    insert into ql_rap.ve(mave,ngaybanve,ngaychieu,giave) values('mv1','2020/02/02','2020/02/02','600000');
    insert into ql_rap.ve(mave,ngaybanve,ngaychieu,giave) values('mv2','2020/01/02','2020/01/02','600000');
    insert into ql_rap.ve(mave,ngaybanve,ngaychieu,giave) values('mv3','2020/05/02','2020/05/02','600000');
    insert into ql_rap.ve(mave,ngaybanve,ngaychieu,giave) values('mv4','2020/08/02','2020/08/02','600000');
    

create table rap(
	marap			char(20) unique,
    tenchinhanh		nvarchar(300),
	soluongrap		int,
    mave			char(20),
    primary key(marap),
    FOREIGN KEY (mave) REFERENCES ve(mave)
);
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr01',N'Q.1, Tp. Hồ Chí Minh','1','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr02',N'135 Hai Bà Trưng, Q.1','3','mv2') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr03',N'P.2, Q.3, Tp. Hồ Chí Minh','2','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr04',N'Số 6, Mạc Đĩnh Chi, Q.1','1','mv2') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr05',N'116 Nguyễn Du, Q.1,','3','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr06',N'246 Nguyễn Hồng Đào, Q.Tân Bình','5','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr07',N'718bis Kinh Dương Vương, Q.6','1','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr08',N'Lầu 3, CoopMart Foodcosa, 304A Quang Trung, P.11','7','mv2') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr09',N'Trung Tâm Văn Hóa Quận 12','1','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr10',N'119B Nguyễn Văn Quá, P. Đông Hưng Thuận, Q.12','2','mv1') ;
insert into rap(marap,tenchinhanh,soluongrap,mave) values ('mr11',N'Tầng 7, Hùng Vương Plaza, 126 Hùng Vương, Q.5','1','mv4') ;

update ql_rap.rap set tenchinhanh=N'Quan 2',soluongrap='3',mave='mv2' where marap='mr01';
DELETE FROM ql_rap.rap WHERE marap = 'mr';
select * from ql_rap.rap;

create table ql_rap.chitiet(
	marap		char(20),
    maphim		char(20),
    FOREIGN KEY (marap) REFERENCES rap(marap),
    FOREIGN KEY (maphim) REFERENCES phim(maphim)
);

create table ql_rap.phim(
	maphim		char(20) unique,
    tenphim		nvarchar(100),
    thoigian	char(20),
    quocgia		nvarchar(100),
    daodien		nvarchar(100),
    diendien	nvarchar(100),
    suatchieu	datetime,
    giobatdau	char(20),
    gioketthuc	char(20),
    primary key(maphim)
);

INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp01',N'Em chưa 18+','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');
INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp02',N'Tiệt Trăng máu','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');
INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp03',N'RÒm','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');
INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp04',N'Ác quỷ dối đầu','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');
INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp05',N'Tenet','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');
INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp06',N'American fighter','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');
INSERT into ql_rap.phim(maphim,tenphim,thoigian,quocgia,daodien,diendien,suatchieu,giobatdau,gioketthuc) values('mp07',N'The doorman','60p',N'Việt Nam',N'Trần Viễn',N'thaihoa','2020/02/01','7h','8h45');

update ql_rap.phim set tenphim='Hoa hong',thoigian='90p',quocgia='hongkong',daodien='lyhung',diendien='hai',suatchieu='2020/05/01',giobatdau='11h', gioketthuc='13h' where maphim='mp';
DELETE FROM ql_rap.phim WHERE maphim = 'mp';
select * from ql_rap.phim







    
    
    
    
    
    



Select * from taikhoan where taikhoan and matkhau

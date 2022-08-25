using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Entity
{
   public class SANPHAM
    {
        [Key]
        public String masp { get; set; }
        public string tensp { get; set; }
        public int gia { get; set; }
        public int soluong { get; set; }
        public string hinh { get; set; }
        public string mota { get; set; }
        public string kichco { get; set; }
        public string maloai { get; set; }
    }
}

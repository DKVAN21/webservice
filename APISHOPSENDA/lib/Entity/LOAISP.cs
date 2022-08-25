using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lib.Entity
{
    public class LOAISP
    {
        [Key]
        public string maloai { get; set; }
        public string tenloai { get; set; }
    }
}

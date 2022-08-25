using APISHOPSENDA.Models;
using lib.Entity;
using lib.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace APISHOPSENDA.Controllers.api
{
    [Route("api/[controller]")]
    [ApiController]
    public class KHACHHANGController : ControllerBase
    {
        private KHACHHANGServices KHACHHANGService;

        public KHACHHANGController(KHACHHANGServices KHACHHANGService)
        {
            this.KHACHHANGService = KHACHHANGService;
        }
        [HttpGet("get-KHACHHANG")]
        public async Task<ActionResult> GetKHACHHANG()
        {
            return Ok(new { status = true, message1 = "", data = KHACHHANGService.GetKHACHHANGList() });
        }
        [HttpGet("get-KTDN")]
        public async Task<ActionResult> KTDNKHACHHANG(KHACHHANGModel Khachhang)
        {
            KHACHHANG kh = new KHACHHANG();
            kh.sdt = Khachhang.sdt;
            kh.pass = Khachhang.pass;

            return Ok(new { status = true, message1 = "", data = KHACHHANGService.KTDN(kh) });
        }
        [HttpPost("insert-KHACHHANG")]
        public async Task<ActionResult> InsertKHACHHANG(KHACHHANGModel Khachhang)
        {
            KHACHHANG kh = new KHACHHANG();
            kh.sdt = Khachhang.sdt;
            kh.tenkh = Khachhang.tenkh;
            kh.pass = Khachhang.pass;
            kh.diachi = Khachhang.diachi;
            kh.email = Khachhang.email;
            KHACHHANGService.InsertKHACHHANG(kh);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPost("Change-KHACHHANG")]
        public async Task<ActionResult> ChangeKHACHHANG(KHACHHANGModel Khachhang)
        {
            KHACHHANG kh = new KHACHHANG();
            kh.sdt = Khachhang.sdt;
            kh.tenkh = Khachhang.tenkh;
            kh.email = Khachhang.email;
            kh.pass = Khachhang.pass;
            kh.diachi = Khachhang.diachi;
            
            KHACHHANGService.ChangeKHACHHANG(kh);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPut("Delete-KHACHHANG")]
        public async Task<ActionResult> DeleteKHACHHANG(KHACHHANGModel Khachhang)
        {
            KHACHHANG kh = new KHACHHANG();
            kh.sdt = Khachhang.sdt;
            KHACHHANGService.DeleteKHACHHANG(kh);
            return Ok(new { status = true, message = "success" });
        }
    }
}

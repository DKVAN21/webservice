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
    public class SANPHAMController : ControllerBase
    {
        
        private SANPHAMServices SANPHAMService;

        public SANPHAMController(SANPHAMServices SANPHAMService)
        {
            this.SANPHAMService = SANPHAMService;
        }
        [HttpGet("get-SANPHAM")]
        public async Task<ActionResult> GetSANPHAM()
        {
            return Ok(new { status = true, message1 = "", data = SANPHAMService.GetSANPHAMList() });
        }
        [HttpPost("insert-SANPHAM")]
        public async Task<ActionResult> InsertSANPHAM(SANPHAMModel Sanpham)
        {
            SANPHAM sp = new SANPHAM();
            sp.masp = Sanpham.masp;
            sp.tensp = Sanpham.tensp;
            sp.gia = Sanpham.gia;
            sp.hinh = Sanpham.hinh;
            sp.kichco = Sanpham.kichco;
            sp.mota = Sanpham.mota;
            sp.soluong = Sanpham.soluong;
            sp.maloai = Sanpham.maloai;
            SANPHAMService.InsertSANPHAM(sp);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPut("Change-SANPHAM")]
        public async Task<ActionResult> ChangeSANPHAM(SANPHAMModel Sanpham)
        {
            SANPHAM sp = new SANPHAM();
            sp.masp = Sanpham.masp;
            sp.tensp = Sanpham.tensp;
            sp.gia = Sanpham.gia;
            sp.hinh = Sanpham.hinh;
            sp.kichco = Sanpham.kichco;
            sp.mota = Sanpham.mota;
            sp.soluong = Sanpham.soluong;
            sp.maloai = Sanpham.maloai;
            SANPHAMService.ChangeSANPHAM(sp);
            return Ok(new { status = true, message = "success" });
        }
        [HttpDelete("Delete-SANPHAM")]
        public async Task<ActionResult> DeleteSANPHAM(SANPHAMModel Sanpham)
        {
            SANPHAM sp = new SANPHAM();
            sp.masp = Sanpham.masp;
            SANPHAMService.DeleteSANPHAM(sp);
            return Ok(new { status = true, message = "success" });
        }
    }
}

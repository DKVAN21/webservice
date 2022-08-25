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
    public class HOADONController : ControllerBase
    {
        private HOADONServices HOADONService;

        public HOADONController(HOADONServices HOADONService)
        {
            this.HOADONService = HOADONService;
        }
        [HttpGet("get-HOADON")]
        public async Task<ActionResult> GetHOADON()
        {
            return Ok(new { status = true, message1 = "", data = HOADONService.GetHOADONList() });
        }
        [HttpPost("insert-HOADON")]
        public async Task<ActionResult> InsertHOADON(HOADONModel Hoadon)
        {
            HOADON gh = new HOADON();
            gh.mahd = Hoadon.mahd;
            gh.sdt = Hoadon.sdt;
            gh.manv = Hoadon.manv;
            gh.masp = Hoadon.masp;
            gh.sdt = Hoadon.sdt;
            HOADONService.InsertHOADON(gh);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPut("Change-HOADON")]
        public async Task<ActionResult> ChangeHOADON(HOADONModel Hoadon)
        {
            HOADON gh = new HOADON();
            gh.mahd = Hoadon.mahd;
            gh.sdt = Hoadon.sdt;
            gh.manv = Hoadon.manv;
            gh.masp = Hoadon.masp;
            gh.sdt = Hoadon.sdt;
            HOADONService.ChangeHOADON(gh);
            return Ok(new { status = true, message = "success" });
        }
        [HttpPost("Delete-HOADON")]
        public async Task<ActionResult> DeleteHOADON(HOADONModel Hoadon)
        {
            HOADON gh = new HOADON();
            gh.mahd = Hoadon.mahd;
            gh.sdt = Hoadon.sdt;
            gh.manv = Hoadon.manv;
            HOADONService.DeleteHOADON(gh);
            return Ok(new { status = true, message = "success" });
        }
    }
}

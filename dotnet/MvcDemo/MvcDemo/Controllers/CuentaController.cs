using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcDemo.Models;

namespace MvcDemo.Controllers
{
    public class CuentaController : Controller
    {
        //
        // GET: /Cuenta/

        public ActionResult Index()
        {
            var model = new List<Cuenta> 
            {
                new Cuenta { Cliente = "Cliente 1", IdCuenta = 1, Nombre = "Cuenta", Saldo = 1000, Tipo = "Ahorros" },
                new Cuenta { Cliente = "Cliente 2", IdCuenta = 2, Nombre = "Cuenta", Saldo = 1000, Tipo = "Ahorros" }
            };

            return View(model);
        }

        public ActionResult EditCuenta()
        {
            return View();
        }
    }
}

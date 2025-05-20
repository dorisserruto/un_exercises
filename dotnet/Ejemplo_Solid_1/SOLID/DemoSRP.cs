using System;
using System.Collections.Generic;
using System.Windows.Forms;
using SOLID.SRP;

namespace SOLID
{
    public partial class DemoSRP : Form
    {
        CarritoDeCompras _carritoDeCompras;
        private double montoTotal = 0;

        public DemoSRP()
        {
            InitializeComponent();
        }

        private void DemoSRP_Load(object sender, EventArgs e)
        {
            _carritoDeCompras = new CarritoDeCompras();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            _carritoDeCompras.Items.Add(new Item { Identificador = "iPad", Cantidad = 1, CodigoInventario = "ABSSZXA", Precio = 1800});
            MostrarCarritoDeCompras();
        }
        private void pictureBox3_Click(object sender, EventArgs e)
        {
            _carritoDeCompras.Items.Add(new Item { Identificador = "Surface", Cantidad = 1, CodigoInventario = "DDDFSDF", Precio = 1500 });
            MostrarCarritoDeCompras();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            _carritoDeCompras.Items.Add(new Item { Identificador = "Xperia Z", Cantidad = 1, CodigoInventario = "DASF3D", Precio = 1700 });
            MostrarCarritoDeCompras();
        }

        private void MostrarCarritoDeCompras()
        {
            textBox3.Text = string.Empty;
            montoTotal = 0;
            
            foreach (var item in _carritoDeCompras.Items)
            {
                textBox3.AppendText("[1] " + item.Identificador + Environment.NewLine);
                montoTotal += item.Precio;
            }
            Total.Text = "S/. " + montoTotal.ToString("0000.00");
        }
    }
}

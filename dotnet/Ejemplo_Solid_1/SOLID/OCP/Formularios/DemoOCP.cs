using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using SOLID.OCP;

namespace SOLID
{
    public partial class DibujarFormas : Form
    {
        public DibujarFormas()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Cuadrado cuadrado = new Cuadrado();
            cuadrado.Draw();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Circulo circulo = new Circulo();
            circulo.Draw();
        }

        /*private void button3_Click(object sender, EventArgs e)
        {
            Triangulo circulo = new Triangulo();
            circulo.Draw();
        }*/

        private void button4_Click(object sender, EventArgs e)
        {
            
            var list = new List<FiguraGeometrica> ();
            list.Add(new Circulo());
            list.Add(new Cuadrado());
            list.Add(new Cuadrado());
            list.Add(new Circulo());
            
            //list.Add(new Triangulo());
            var dibujarFormas = new DibujarFigurasGeometricas();
            dibujarFormas.DrawAllShapes(list);
        }
    }
}

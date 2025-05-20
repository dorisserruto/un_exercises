using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;

namespace SOLID.OCP
{
    public abstract class FiguraGeometrica
    {
        public abstract void Draw();
    }

    public class Cuadrado : FiguraGeometrica
    {
        public int Lado { get; set; }

        public override void Draw()
        {
            Form formularioCuadrado = new PlantillaCuadrado();

            formularioCuadrado.Width = 100;
            formularioCuadrado.Height = 100;

            formularioCuadrado.Show();
        }
    }

    public class Circulo : FiguraGeometrica
    {
        public int Radio { get; set; }

        public override void Draw()
        {
            Form formularioCirculo = new PlantillaCirculo();
            formularioCirculo.Show();
        }
    }

/*    public class Triangulo : FiguraGeometrica
    {
        public int Alto { get; set; }
        public int Base { get; set; }

        public override void Draw()
        {
            Form formularioCirculo = new PlantillaTriangulo();
            formularioCirculo.Show();
        }
    }*/

    public class DibujarFigurasGeometricas
    {
        public void DrawAllShapes(List<FiguraGeometrica> list)
        {
            foreach (FiguraGeometrica i in list)
                i.Draw();
        }

    }
}
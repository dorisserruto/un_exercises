using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing.Drawing2D;

namespace SOLID.OCP
{
    public partial class PlantillaTriangulo : Form
    {
        public PlantillaTriangulo()
        {
            InitializeComponent();
        }

        //private void PlantillaCirculo_Load(object sender, EventArgs e)
        //{
        //    Height = 100;
        //    Width = 100;
        //    GraphicsPath path = new GraphicsPath();
        //    path.AddEllipse(0, 0, 100, 100);


        //    Point[] points = { new Point(10, 10), new Point(100, 10), new Point(50, 100) };
        //    path.AddPolygon(points);

        //    Region = new Region(path);

        //    BackColor = CreateRandomColor();


        //    Graphics surface;
        //    surface = this.CreateGraphics();
        //    SolidBrush brush = new SolidBrush(CreateRandomColor());
        //    Point[] points = { new Point(10, 10), new Point(100, 10), new Point(50, 100) };
        //    surface.FillPolygon(brush, points);

        //}

        protected Color CreateRandomColor()
        {
            Random randonGen = new Random();
            Color randomColor = Color.FromArgb(randonGen.Next(255), randonGen.Next(255), randonGen.Next(255));

            return randomColor;
        }

        private void PlantillaCirculo_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void PlantillaTriangulo_Load(object sender, EventArgs e)
        {
            Height = 100;
            Width = 100;
            GraphicsPath path = new GraphicsPath();
            //path.AddEllipse(0, 0, 100, 100);

            Point[] points = { new Point(50, 100), new Point(100, 10), new Point(10, 10) };
            path.AddPolygon(points);

            Region = new Region(path);

            BackColor = CreateRandomColor();


            //    Graphics surface;
            //    surface = this.CreateGraphics();
            //    SolidBrush brush = new SolidBrush(CreateRandomColor());
            //    Point[] points = { new Point(10, 10), new Point(100, 10), new Point(50, 100) };
            //    surface.FillPolygon(brush, points);

        }

    }
}

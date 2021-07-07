package Übung7;

import javafx.geometry.Point2D;

class Rechteck {
	
		private Point2D UL;
		private Point2D OR;

		public Rechteck(Point2D ul,Point2D or) throws Exception {
			if(ul.getX() > or.getX() && ul.getY() > or.getY()) {
				throw new IllegalArgumentException("Falsche Eingabe");
			}
			this.UL = ul;
			this.OR = or;
	
		}
		public double berechneUmfang() {
			double breite= Math.sqrt((Math.pow((OR.getX()-UL.getX()), 2)));
			double hoehe=Math.sqrt((Math.pow((OR.getY() - UL.getY()), 2)));

			return (2*(hoehe+breite));
		}
		public double berechneFlaeche() {
			double breite= Math.sqrt((Math.pow((OR.getX() - UL.getX()), 2)));
			double hoehe = Math.sqrt((Math.pow((OR.getY() - UL.getY()), 2)));
			return breite*hoehe ;
		}
		public boolean isQuadrat() {
			double breite= Math.sqrt((Math.pow((OR.getX()-UL.getX()),2)));
			double hoehe=Math.sqrt((Math.pow((OR.getY()-UL.getY())   ,2)));

			return (hoehe == breite);
		}
		public boolean contains(Point2D a) {
			if((( a.getX( )> OR.getX() && a.getY() > OR.getY()) &&
					( a.getX()< UL.getX() && a.getY() < UL.getY()))) {
				return false;
			}
			return true;
		}
		public boolean schneidet(Rechteck e) {
			if(!(this.UL== e.UL && this.OR== e.OR)){
				return false;
			}
			return true;
		}
		@Override
		public String toString() {
			return UL+ " " +OR;
		}


	
}

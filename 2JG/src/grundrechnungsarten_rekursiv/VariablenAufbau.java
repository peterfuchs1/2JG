package grundrechnungsarten_rekursiv;

public interface VariablenAufbau {

		public final static int START=0;
		public final static int STOPP=9;
		public final static int VALUE=0;
		
		
		/**
		 * @return the start
		 */
		public int getStart();
		/**
		 * @param start the start to set
		 */
		public void setStart(int start) ;
		/**
		 * @return the stopp
		 */
		public int getStopp() ;
		/**
		 * @param stopp the stopp to set
		 */
		public void setStopp(int stopp) ;
		/**
		 * @return the value
		 */
		public int getValue() ;
		/**
		 * @param value the value to set
		 */
		public void setValue(int value);
		/**
		 * @return the fix
		 */
		public boolean isFix();
		/**
		 * @param fix the fix to set
		 */
		public void setFix(boolean fix); 

	}

	


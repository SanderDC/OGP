package associations;

public enum Gender {
	
	FEMALE{
		@SuppressWarnings("unused")
		public char getSymbol(){
			return '\u2640';
		}
	}
	
	,
	
	MALE {
		@SuppressWarnings("unused")
		public char getSymbol(){
			return '\u2642';
		}
	}
}

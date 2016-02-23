package associations;

public enum Gender {
	
	FEMALE{
		public char getSymbol(){
			return '\u2640';
		}
	}
	
	,
	
	MALE {
		public char getSymbol(){
			return '\u2642';
		}
	}
}

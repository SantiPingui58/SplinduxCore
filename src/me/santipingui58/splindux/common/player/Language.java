package me.santipingui58.splindux.common.player;


public enum Language {

	SPANISH,
	ENGLISH,
	RUSSIAN;
	public String toGoogleType() {
		if (this.equals(Language.SPANISH)) {
			return "es";
		} else if (this.equals(Language.ENGLISH)) {
			return "en";
		} else if (this.equals(Language.RUSSIAN)) {
			return "ru";
		}
		return null;
	}
	
	
	public static Language fromGoogleType(String str) {
		if (str.equalsIgnoreCase("es")) {
			return SPANISH;
		} else if (str.equalsIgnoreCase("en")){
			return ENGLISH;
		} else if (str.equalsIgnoreCase("ru")) {
			return RUSSIAN;
		}
		
		return null;
	}
}

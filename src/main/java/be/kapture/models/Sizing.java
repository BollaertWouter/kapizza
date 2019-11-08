package be.kapture.models;

public enum Sizing {
	S("small"), M("medium", "33cl"), L("large", "50cl"), XXL("xxl", "1,5L");

	String size;
	String volume;

	Sizing(String size) {
		this.size = size;
		this.volume = null;
	}

	Sizing(String size, String volume) {
		this.size = size;
		this.volume = volume;
	}

	public String getSize() {
		return size;
	}

	public String getVolume() {
		return volume;
	}
}

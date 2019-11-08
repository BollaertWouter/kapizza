package be.kapture.web;

import be.kapture.models.Sizing;
import org.junit.jupiter.api.Test;

import static be.kapture.web.Scraper.*;
import static org.assertj.core.api.Assertions.assertThat;

class ScraperTest {
	@Test
	void convertPriceToDouble_convertEuro() {
		assertThat(convertPriceToDouble("€12,50")).isEqualTo(12.50);
		assertThat(convertPriceToDouble("€12.50")).isEqualTo(12.50);
	}

	@Test
	void convertPriceToDouble_convertNormalNumber() {
		assertThat(convertPriceToDouble("12,50")).isEqualTo(12.50);
		assertThat(convertPriceToDouble("12.50")).isEqualTo(12.50);
	}

	@Test
	void convertPriceToDouble_faultyNumber() {
		assertThat(convertPriceToDouble("a")).isEqualTo(-1.0);
	}

	@Test
	void getProductName_correctName() {
		assertThat(getProductName("Creamy dream large")).isEqualTo("Creamy dream");
		assertThat(getProductName("Creamy dream")).isEqualTo("Creamy dream");
	}

	@Test
	void getProductSize_correctSize() {
		assertThat(getProductSize("Creamy dream large")).isEqualTo(Sizing.L);
	}
}

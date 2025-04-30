package com.sit.dao;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonDAOImpl implements ISeasonDAO {

	@Override
	public String ShowSeason() {
		LocalDate d=LocalDate.now();

		int m=d.getMonthValue();

		if(m>=7 && m<=10) {
			return "Rainy season";
		}
		else if(m>=3 && m<=6) {
			return "Summer season";
		}
		else
			return "Winter Season";

	}

}

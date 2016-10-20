package com.joyuri.web.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component("offerDao")
public class OfferDAO {
	private NamedParameterJdbcTemplate jdbc;
	
	public OfferDAO() {
		System.out.println("Successfully loaded offers DAO");
	}

	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers(){
		return jdbc.query("select * from offer", new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
		});
	}
	
	public Offer getOffers(int id){
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		
		return jdbc.queryForObject("select * from offer where id = :id", param, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
		});
	}
	
	public boolean create(Offer offer){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offer (name, email, text) values (:name, :email, :text)", param) == 1;
	}
	
	public int[] create(List<Offer> offers){
		SqlParameterSource[] param = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("insert into offer (name, email, text) values (:name, :email, :text)", param);
	}
	
	public boolean update(Offer offer){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offer set name = :name, email = :email, text = :text where id = :id", param) == 1;
	}
	
	public boolean delete(int id){
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offer where id = :id", param) == 1;
	}
}

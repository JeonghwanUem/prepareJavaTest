package market.dao;

import java.util.ArrayList;

import java.util.HashMap;

import market.vo.market;

public interface marketMapper {

	public void insertMarket(String name);

	public ArrayList<market> salesTable(HashMap<String, String> buyer);

	public void insertUser(market market);

	public ArrayList<market> selectOneUser(HashMap<String, String> map);

	public market selectPrice(market market);

	public ArrayList<market> buyNow(HashMap<String, String> map);

	public void insertSell(String name);

	public market callPrice(String name);

	public market deleteName(market market);

	public market updateSum(market market);

	public ArrayList<market> AllMenu();
	
	public ArrayList<market> selectOneName();
	
	public market selectSumAndSell(String name);

	public ArrayList<market> selectAll();
	
	public ArrayList<market> selectUser();
}

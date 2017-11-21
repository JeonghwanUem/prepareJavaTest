package market.dao;

import java.util.ArrayList;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import market.vo.market;

public class marketDAO {

	private SqlSessionFactory factory = mybatisConfig.getSqlSessionFactory();

	// 기능별로 함수가 필요한 상황
	// 등록 기능
	public market insertMarket(String name) {
		SqlSession session = null;
		market market = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			mapper.insertMarket(name);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return market;
	}

	public ArrayList<market> salesTable(HashMap<String, String> buyer) {
		SqlSession session = null;
		ArrayList<market> list = null;

		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			list = mapper.salesTable(buyer);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return list;
	}

	public market insertUser(market market) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			mapper.insertUser(market);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return market;
	}

	public ArrayList<market> selectOneUser(HashMap<String, String> map) {
		SqlSession session = null;
		ArrayList<market> list = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			list = mapper.selectOneUser(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public market selectPrice(market market) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			mapper.selectPrice(market);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return market;

	}

	public ArrayList<market> buyNow(HashMap<String, String> map) {
		SqlSession session = null;
		ArrayList<market> list = new ArrayList<>();
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			list = mapper.buyNow(map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;

	}

	public market insertSell(String name) {
		SqlSession session = null;
		market market = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			mapper.insertSell(name);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
			return market;
	}

	public market callPrice(String name) {
		SqlSession session = null;
		market market = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			market = mapper.callPrice(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return market;
	}

	public market deleteName(market market) {
		SqlSession session = null;
		market = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			market = mapper.deleteName(market);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return market;
	}

	public market updateSum(market market) {
		SqlSession session = null;
		market = null;
		try {
			session = factory.openSession();
			marketMapper mapper = session.getMapper(marketMapper.class);
			market = mapper.updateSum(market);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return market;
	}

	public ArrayList<market> AllMenu() {
		SqlSession ss = null;
		ArrayList<market> list = null;
		try {
			ss = factory.openSession();
			marketMapper mapper = ss.getMapper(marketMapper.class);
			list = mapper.AllMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
		return list;
	}

	public ArrayList<market> selectOneName() {
		SqlSession ss = null;
		ArrayList<market> list = null;
		try {
			ss = factory.openSession();
			marketMapper mapper = ss.getMapper(marketMapper.class);
			list = mapper.selectOneName();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
		return list;
	}

	public market selectSumAndSell(String name) {
		SqlSession ss = null;
		market market = null;

		try {
			ss = factory.openSession();
			marketMapper mapper = ss.getMapper(marketMapper.class);
			market = mapper.selectSumAndSell(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
		return market;
	}

	public ArrayList<market> selectAll() {
		SqlSession ss = null;
		ArrayList<market> list = null;
		try {
			ss = factory.openSession();
			marketMapper mapper = ss.getMapper(marketMapper.class);
			list = mapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
		return list;
	}

	public ArrayList<market> selectUser() {
		SqlSession ss = null;
		ArrayList<market> list = null;
		try {
			ss = factory.openSession();
			marketMapper mapper = ss.getMapper(marketMapper.class);
			list = mapper.selectUser();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}
		return list;
	}
}

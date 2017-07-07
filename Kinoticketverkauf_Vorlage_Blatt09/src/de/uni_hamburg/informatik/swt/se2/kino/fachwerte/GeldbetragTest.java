package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest {

	Geldbetrag _g1;
	Geldbetrag _g2;
	Geldbetrag _g3;
	
	
	
	public GeldbetragTest(){
		_g1 = new Geldbetrag(10,20);
		_g2 = new Geldbetrag(6,30);
		_g3 = new Geldbetrag(10,80);
	}
	
	@Test
	public void testAdd(){
		Geldbetrag _g0 = new Geldbetrag(16,50);
		
		_g1.addGeldbetrag(_g2);
		assertEquals(_g0.get_euro(),_g1.get_euro());
		assertEquals(_g0.get_cent(),_g1.get_cent());
		
	}
	
	@Test
	public void testMul(){
		Geldbetrag _g0 = new Geldbetrag(20,40);
		
		_g1.mulGeldbetrag(2);
		assertEquals(_g0.get_euro(),_g1.get_euro());
		assertEquals(_g0.get_cent(),_g1.get_cent());
	}
	@Test
	public void TestKonstruktorFloat(){
		Geldbetrag _g0 = new Geldbetrag(10.80);
		assertEquals(_g0.get_euro(), _g3.get_euro());
		assertEquals(_g0.get_cent(), _g3.get_cent());
	}
	
	@Test
	public void TestKonstruktorString(){
		Geldbetrag _g0 = new Geldbetrag("10,80");
		assertEquals(_g0.get_euro(), _g3.get_euro());
		assertEquals(_g0.get_cent(), _g3.get_cent());
	}
		
}

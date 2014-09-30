package ru.spbstu.telematics.lecture2;

import java.awt.Label;
import java.awt.Point;
import java.util.Date;

import ru.spbstu.telematics.lecture2.a.AbstractCreature;
import ru.spbstu.telematics.lecture2.a.Action;
import ru.spbstu.telematics.lecture2.a.BlackCreature;
import ru.spbstu.telematics.lecture2.a.Button;
import ru.spbstu.telematics.lecture2.a.Creature;
import ru.spbstu.telematics.lecture2.a.Example1;
import ru.spbstu.telematics.lecture2.a.ExictAction;
import ru.spbstu.telematics.lecture2.a.PojoExample;

public class Main {
	public static void main(String[] args) {
		Example1 ex = new Example1(2, 3);
		
		System.out.println("Static value: " + Example1.num);
		System.out.println(ex.val2);
		
		PojoExample po = new PojoExample(2, "abcde");
		System.out.println(po.getName());
		
		Creature c1 = new Example1(3, 3);
		c1.live();
		
		Example1 cex1 = (Example1) c1;
		
		AbstractCreature ac = new BlackCreature();
		ac.live();
		
		final Label label = new Label();
		
		Action exitAction = new ExictAction();
		Button exitButton = new Button(exitAction);
		
		Button changeButton = new Button(new Action() {
			
			@Override
			public void doClick(Point c) {
				label.setText("abcde");
			}
		});
	}
}

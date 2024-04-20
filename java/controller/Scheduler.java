package controller;

import java.sql.SQLException;

import dao.Dao;

public class Scheduler implements Runnable {

	@Override
	public void run() {
		while (Thread.currentThread().isInterrupted()) {
			Dao dao = new Dao();
			 
			try {
				dao.updatePriorityBasedOnDuration();
				System.out.println("============from Scheduler class===========");
				Thread.sleep(1000*30);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			
		}
		
	}

}

package edu.mum.cs.cs544.aop;

import javax.swing.JDialog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class ProjectAspect {
	//@After("within(edu.mum.cs.cs544.dao.AbstractDao.delete(..)")
	
	@After("execution(void edu.mum.cs.cs544.service.impl.StudentServiceImpl.deleteStudent(..))")
	public void alertForDelete(JoinPoint joinpoint) {
		JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		javax.swing.JOptionPane.showMessageDialog(dialog, "Deleted Successfully");
		
	}
	
	/*@After("execution(void edu.mum.cs.cs544.dao.impl.StudentDaoImpl.deleteStudent(..))")
	public void alertForDel(JoinPoint joinpoint) {
		System.out.println("Deletion take place at this point");
		javax.swing.JOptionPane.showMessageDialog(null, "Deleted Successfully");
	}*/
}
package lt.vtvmpc.akademijaIT.tests;


import lt.vtvmpc.akademijaIT.PostOfficeImpl;
import lt.vtvpmc.java.postoffice.AbstractPostOfficeTest;
import lt.vtvpmc.java.postoffice.PostOffice;

public class PostOfficeTestImpl extends AbstractPostOfficeTest {

	@Override
	protected PostOffice getPostOffice() {
		return new PostOfficeImpl();
	}
	
}

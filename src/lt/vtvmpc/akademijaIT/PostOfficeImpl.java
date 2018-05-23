package lt.vtvmpc.akademijaIT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import lt.vtvpmc.java.postoffice.IllegalPackageException;
import lt.vtvpmc.java.postoffice.Package;
import lt.vtvpmc.java.postoffice.PostOffice;

public class PostOfficeImpl implements PostOffice {

	final static Logger logger = Logger.getLogger(PostOfficeImpl.class);

	List<Package> packages = new ArrayList<>();

	/**
	 * Retrieve number of owner packages;
	 * 
	 * @param String
	 *            owner
	 */
	@Override
	public long numberOfPackagesForOwner(String owner) {
		List<Package> ownerPackages = new ArrayList<>();
		if (owner.equals(null)) {
			throw new IllegalArgumentException();
		}
		ownerPackages = packages.stream().filter(p -> p.getOwner().equals(owner))
		.collect(Collectors.toList());

		logger.warn("Retrieve owner packages");
		return ownerPackages.size();
	}

	@Override

	/**
	 * Posting package if it has owner and packageCode
	 * 
	 * @param Package package
	 */
	public void postPackage(Package pkg) throws IllegalPackageException {

		if (pkg.getOwner() == null || pkg.getPackageCode() == null || 
			pkg.getOwner().length() == 0
		    || pkg.getPackageCode().length() ==0) {
			logger.warn("Package don't have owner or packageCode");
			throw new IllegalPackageException();

		}
		logger.info("Adding package to postInventor");
		packages.add(pkg);

	}

	/**
	 * Retrieve package and removes it from postInventor;
	 * 
	 * @param String packageCode
	 */
	@Override
	public Package retrievePackage(String packageCode) {
		for (Package p : packages) {
			if (p.getPackageCode().equals(packageCode)) {
				packages.remove(p);
				logger.warn("Retrieve package");
				return p;
			}
		}
		return null;
	}

}

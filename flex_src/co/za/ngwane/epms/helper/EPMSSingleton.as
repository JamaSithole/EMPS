package co.za.ngwane.epms.helper
{
	import co.za.ngwane.epms.repository.Clustertbl;
	import co.za.ngwane.epms.repository.Dept;
	import co.za.ngwane.epms.repository.Directorate;
	import co.za.ngwane.epms.repository.Ndp;
	import co.za.ngwane.epms.repository.Ndpltems;
	import co.za.ngwane.epms.repository.Outcometbl;
	import co.za.ngwane.epms.repository.Outputtbl;
	import co.za.ngwane.epms.repository.Progtbl;
	import co.za.ngwane.epms.repository.Projtbl;
	import co.za.ngwane.epms.repository.Qoupd;
	import co.za.ngwane.epms.repository.Sectiontbl;
	import co.za.ngwane.epms.repository.Userepms;
	
	import content.Ndplinkitems;
	
	import flash.sampler.NewObjectSample;
	
	import mx.collections.ArrayCollection;
	
	import spark.components.Button;

	[Bindable] //By setting a class as "Bindable", all variables within the Class are bindable
	/**
	 * TMSSingleton Class
	 **/
	public class EPMSSingleton // this is a class information
	{
		static private var _instance:EPMSSingleton; //instance information
		
		/**
		 * The Constructor
		 * <p>The constructor requires a SingletonEnforcer, so that another
		 * instance of the constructor can't be called directly.</p>
		 **/
		public function EPMSSingleton(enforcer:SingletonEnforcer)
		{
		}
		
		/**
		 * Most Singleton Objects have a point of entry, the "getInstance" static function.
		 * <p>The "getInstance" static function checks to see if the "_instance" private
		 * variable exists, if it does return the existing "_instance", if not, return
		 * a new MySingleton "_instance" variable.</p>
		 **/
		public static function getInstance():EPMSSingleton
		{
			if(EPMSSingleton._instance==null)
				EPMSSingleton._instance = new EPMSSingleton(new SingletonEnforcer())
			return EPMSSingleton._instance;
		}
		
		/**
		 * This is an example of a variable available in the Singleton Class
		 **/
		public var now:Date = new Date();
		public var loggedIn : Boolean = false;
		public var space : String = " ";
		
		public var selectedUser : Userepms;
		public var selectedCluster : Clustertbl;
		public var selectedDirectorate : co.za.ngwane.epms.repository.Directorate;
		public var selectedOutcome : Outcometbl;
		public var selectedDept : Dept;
		public var selectedProg : co.za.ngwane.epms.repository.Progtbl;
		public var selectedNdp : co.za.ngwane.epms.repository.Ndp;
		public var selectedNdpItem : co.za.ngwane.epms.repository.Ndpltems;
		public var selectedProj : Projtbl;
		public var selectedOutput : Outputtbl;
		public var selectedOutputPoe : Outputtbl;
		public var selectedQoup : Qoupd;
		public var selectedQoupPoe : Qoupd;
		public var selectedSection : Sectiontbl;
		public var selectedNdplinkitem : Ndplinkitems;
		
		public var prog : Progtbl;
		
		public var currentUser : co.za.ngwane.epms.repository.Userepms = new co.za.ngwane.epms.repository.Userepms;
		
		public var dirList : ArrayCollection = new ArrayCollection();
		public var dirNameList : ArrayCollection = new ArrayCollection();
		public var clusterList : ArrayCollection = new ArrayCollection();
		public var clusterNameList : ArrayCollection = new ArrayCollection();
		public var deptList : ArrayCollection = new ArrayCollection();
		public var deptNameList : ArrayCollection = new ArrayCollection();
		public var sectionList : ArrayCollection = new ArrayCollection();
		public var sectionNameList : ArrayCollection = new ArrayCollection();
		public var ndpList : ArrayCollection = new ArrayCollection();
		public var ndpNameList : ArrayCollection = new ArrayCollection();
		public var ndpItemList : ArrayCollection = new ArrayCollection();
		public var ndpItemNameList : ArrayCollection = new ArrayCollection();
		
		public var progList : ArrayCollection = new ArrayCollection();
		public var progListFormatted : ArrayCollection = new ArrayCollection();
		public var progNameList : ArrayCollection = new ArrayCollection();
		
		public var projectList : ArrayCollection = new ArrayCollection();
		public var projectListFormatted : ArrayCollection = new ArrayCollection();
		public var projectNameList : ArrayCollection = new ArrayCollection();
		
		public var outcomeList : ArrayCollection = new ArrayCollection();
		public var outcomeNameList : ArrayCollection = new ArrayCollection();
		
		public var userModsList : ArrayCollection = new ArrayCollection();
		
		public var usersList : ArrayCollection = new ArrayCollection();
		public var usersNameList : ArrayCollection = new ArrayCollection();
		
		public var projNdpItemsList : ArrayCollection = new ArrayCollection();
		public var projNdpItemNameList : ArrayCollection = new ArrayCollection();
		
		public var progNdpLinkList : ArrayCollection = new ArrayCollection();
		public var progNdpLinkNameList : ArrayCollection = new ArrayCollection();
		
		public var progNdpLinkBeanList : ArrayCollection = new ArrayCollection();
		public var addProgNdpList : ArrayCollection = new ArrayCollection();
		
		public var outputList : ArrayCollection = new ArrayCollection();
		public var outputListPoe : ArrayCollection = new ArrayCollection();
		public var outputListPoe4mated : ArrayCollection = new ArrayCollection();
		
		public var selectedNpdItemList : ArrayCollection = new ArrayCollection();
		public var selectedNpdList : ArrayCollection = new ArrayCollection();	
		
		public var selectedSysModList : ArrayCollection = new ArrayCollection();
		
		public var selectedNpdListAddProgNdp : ArrayCollection = new ArrayCollection();
		
		public var selectedDataSignOff : ArrayCollection = new ArrayCollection();
		public var dataSignOffList : ArrayCollection = new ArrayCollection();
		
		public var selectedRejectedDataSignOff : ArrayCollection = new ArrayCollection();
		public var rejectedDataSignOffList : ArrayCollection = new ArrayCollection();

		public var addProProjNdpItemsList : ArrayCollection = new ArrayCollection();
		public var progNdpList : ArrayCollection = new ArrayCollection();
		
		public var planList : ArrayCollection = new ArrayCollection();
		public var planListFormatted : ArrayCollection = new ArrayCollection();
		
		public var filesList : ArrayCollection = new ArrayCollection();
		public var poeList : ArrayCollection = new ArrayCollection();
		
		public var sysModsList : ArrayCollection = new ArrayCollection();
		public var sysModsClientList : ArrayCollection = new ArrayCollection();
		
		public var quator : Boolean = false;
		
		public var quator1 : Boolean = false;
		public var quator2 : Boolean = true;
		public var quator3 : Boolean = false;
		public var quator4 : Boolean = false;
		
		public var quatorTargetNotMet : Boolean = false;
		
		public var q1Txt : String = "Quator 1 Actual:";
		public var q2Txt : String = "Quator 2 Actual:";
		public var q3Txt : String = "Quator 3 Actual:";
		public var q4Txt : String = "Quator 4 Actual:";
		
		public var q1TarTxt : String = "Quator 1 Target:";
		public var q2TarTxt : String = "Quator 2 Target:";
		public var q3TarTxt : String = "Quator 3 Target:";
		public var q4TarTxt : String = "Quator 4 Target:";
		
		//Menu Buttons
		public var homeLbl : String = "Home";
		public var municipalLbl : String = "Organisational Structure";
		public var sectionLbl : String = " Programmes and Projects";
		public var poeLbl : String = "Portfolio Of Evidence";
		public var ndpLbl : String = "Strategy";
		public var usersLbl : String = "User Management";
		public var dataSignOffLbl : String = "Data Sign-Off";
		public var rejectedDataSignOffLbl : String = "Rejected Data Sign Off";
		public var reportLbl : String = "Report";
		public var budRptLbl : String = "Budget Report";
		public var scoringRptLbl : String = "Scoring Report";
		public var dashBoardLbl : String = "Dash Boards";
		
		public var internalAuditLbl : String = "Internal Audit";
		public var auditTrailLbl : String = "Audit Trail";
		public var comEmailLbl : String = "Email";
		public var comSmslLbl : String = "Sms";
		
		public var logoutLbl : String = "Log Out";
		
		public var rptType : String = "";
		
		public var newLine : String = "\n";
		
		public var thirdPoint : String = "ePMS enables organisations to capture and track all activities related to individual and organisational performance with " +newLine+
			" a view to ensuring that these activities are correctly aligned to organisational as well as provincial and national government strategy and goals.";
		
		public var myHtmlText : String="This string contains <b>less than </b>, &lt;, <b>greater than</b>, &gt;, <b>ampersand</b>, &amp;, and <b>double quotation mark</b>, &quot;, characters.";
		
		
		public var auditStatusTxt : String = "Internal Audit Status";
		
		public var homeBT : Boolean = true;
		public var sectionBT : Boolean = true;
		public var poeBT : Boolean = true;
		public var municipalBT : Boolean = true;
		public var usersBT : Boolean = true;
		public var ndpLinksBT : Boolean = true;
		public var dataSignOffBT : Boolean = true;
		public var rejectedDataSignOffBT : Boolean = true;
		public var reportBT : Boolean = true;

		//Userepms permission booleans
		public var userAdd : Boolean = true;
		public var userUpdate : Boolean = true;
		public var userView : Boolean = true;
		public var userDelete : Boolean = true;
		public var userMaintain : Boolean = true;
		
		public var userAccessView : Boolean = true;
		public var userAccessDel : Boolean = true;
		
		//Userepms permission booleans
		public var poeAdd : Boolean = true;
		public var poeView : Boolean = true;
		public var poeDelete : Boolean = true;
		
		//Cluster permission booleans
		public var clusterAdd : Boolean = true;
		public var clusterUpdate : Boolean = true;
		public var clusterView : Boolean = true;
		public var clusterDelete : Boolean = true;
		
		//Directorate
		public var directorateAdd : Boolean = true;
		public var directorateUpdate : Boolean = true;
		public var directorateView : Boolean = true;
		public var directorateDelete : Boolean = true;
		
		//Department
		public var deptAdd : Boolean = true;
		public var deptUpdate : Boolean = true;
		public var deptView : Boolean = true;
		public var deptDelete : Boolean = true;
		
		//Section
		public var sectionAdd : Boolean = true;
		public var sectionUpdate : Boolean = true;
		public var sectionView : Boolean = true;
		public var sectionDelete : Boolean = true;
		
		//Program permission booleans
		public var progAdd : Boolean = true;
		public var progUpdate : Boolean = true;
		public var progView : Boolean = true;
		public var progDelete : Boolean = false;
		
		//Project permission booleans
		public var projAdd : Boolean = true;
		public var projUpdate : Boolean = true;
		public var projView : Boolean = true;
		public var projDelete : Boolean = true;
		
		//Outcome permission booleans
		public var outcomeAdd : Boolean = true;
		public var outcomeUpdate : Boolean = true;
		public var outcomeView : Boolean = true;
		public var outcomeDelete : Boolean = true;
		
		//Output permission booleans
		public var outputAdd : Boolean = true;
		public var outputUpdate : Boolean = true;
		public var outputView : Boolean = true;
		public var outputDelete : Boolean = true;
		
		//Output permission booleans
		public var ndpAdd : Boolean = true;
		public var ndpUpdate : Boolean = true;
		public var ndpView : Boolean = true;
		public var ndpSelect : Boolean = true;
		public var ndpDelete : Boolean = true;
		
		//NdpLinkItem permission booleans
		public var ndpLinkItemAdd : Boolean = true;
		public var ndpLinkItemUpdate : Boolean = true;
		public var ndpLinkItemView : Boolean = true;
		public var ndpLinkItemDelete : Boolean = true;
		
		//NdpLinkItem permission booleans
		public var progNdpLinkItemView : Boolean = true;
		public var progNdpLinkItemDelete : Boolean = true;
		
		//System Module
		public var sysModSelect : Boolean = true;
		
		public var dataSignOffSelect : Boolean = true;

		public var deleteOrRemove : String = "Delete";
		public var edit : String = "Edit";
		public var view : String = "View";
		public var tickToAdd : String = "Tick to add";
		public var add : String = "Add";
		public var addOutput : String = "Add Output";
		public var addPoe : String = "Add P.O.E";
		public var maintain : String = "Maintain";
		
		public var Q1 : String = "Q1";
		public var Q2 : String = "Q2";
		public var Q3 : String = "Q3";
		public var Q4 : String = "Q4";
		
		public var budgetRptTitle : String = "Budget Request Report";
		public var scoringRptTitle : String = "Scoring Request Report";
		
		public var budgetRptPgHdr : String = "Budget Report Request Paramaters";
		public var scoringRptPgHdr : String = "Scoring Report Request Parameters";
		
		public var pgTitle : String = "";
		public var pgHeader : String = "";
		
		public var hundredPercent : Number = 100;
		
		public var attachment : String = "";
		public var separator : String = "\n";
		
	}
}
/**
 * A Class, found declared such as this one, is only available to the package it is found in.
 * <p>This ensures that the class can only be called from the Singleton Object
 * "getInstance" static function</p>
 **/
class SingletonEnforcer{}
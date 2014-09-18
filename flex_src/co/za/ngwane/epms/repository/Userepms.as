package co.za.ngwane.epms.repository
{
	import mx.collections.ArrayCollection;
	
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Userepms")]
	public class Userepms
	{
		private var _id:Number;
		
		private var  _name : String;
		private var  _middlename : String;
		private var  _surname : String;
		private var  _dob : Date;
		private var  _idtype : Number;
		private var  _idnumber : String;
		private var  _username : String;
		private var  _password : String;
		private var  _roleid : Roleepms;
		private var  _sublevelid : Sublevel;
		private var _env : String;
		private var _tempPassword : Boolean;
		private var _contactemail : String;
		private var _contactnumber : String;
		
		private var _usermodCollection : ArrayCollection;
		private var _outputtblCollection : ArrayCollection;
		private var _progtblCollection : ArrayCollection;
		private var _projtblCollection : ArrayCollection;
		private var _outcometblCollection : ArrayCollection;
		
		public function get contactnumber():String
		{
			return _contactnumber;
		}

		public function set contactnumber(value:String):void
		{
			_contactnumber = value;
		}

		public function get contactemail():String
		{
			return _contactemail;
		}

		public function set contactemail(value:String):void
		{
			_contactemail = value;
		}

		public function get id():Number
		{
			return _id;
		}
		
		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get middlename():String
		{
			return _middlename;
		}

		public function set middlename(value:String):void
		{
			_middlename = value;
		}

		public function get surname():String
		{
			return _surname;
		}

		public function set surname(value:String):void
		{
			_surname = value;
		}

		public function get dob():Date
		{
			return _dob;
		}

		public function set dob(value:Date):void
		{
			_dob = value;
		}

		public function get idtype():Number
		{
			return _idtype;
		}

		public function set idtype(value:Number):void
		{
			_idtype = value;
		}

		public function get idnumber():String
		{
			return _idnumber;
		}

		public function set idnumber(value:String):void
		{
			_idnumber = value;
		}

		public function get username():String
		{
			return _username;
		}

		public function set username(value:String):void
		{
			_username = value;
		}

		public function get password():String
		{
			return _password;
		}

		public function set password(value:String):void
		{
			_password = value;
		}

		public function get roleid():Roleepms
		{
			return _roleid;
		}

		public function set roleid(value:Roleepms):void
		{
			_roleid = value;
		}

		public function get sublevelid():Sublevel
		{
			return _sublevelid;
		}

		public function set sublevelid(value:Sublevel):void
		{
			_sublevelid = value;
		}

		public function get env():String
		{
			return _env;
		}

		public function set env(value:String):void
		{
			_env = value;
		}

		public function get tempPassword():Boolean
		{
			return _tempPassword;
		}

		public function set tempPassword(value:Boolean):void
		{
			_tempPassword = value;
		}

		public function get usermodCollection():ArrayCollection
		{
			return _usermodCollection;
		}

		public function set usermodCollection(value:ArrayCollection):void
		{
			_usermodCollection = value;
		}

		public function get outputtblCollection():ArrayCollection
		{
			return _outputtblCollection;
		}

		public function set outputtblCollection(value:ArrayCollection):void
		{
			_outputtblCollection = value;
		}

		public function get progtblCollection():ArrayCollection
		{
			return _progtblCollection;
		}

		public function set progtblCollection(value:ArrayCollection):void
		{
			_progtblCollection = value;
		}

		public function get projtblCollection():ArrayCollection
		{
			return _projtblCollection;
		}

		public function set projtblCollection(value:ArrayCollection):void
		{
			_projtblCollection = value;
		}

		public function get outcometblCollection():ArrayCollection
		{
			return _outcometblCollection;
		}

		public function set outcometblCollection(value:ArrayCollection):void
		{
			_outcometblCollection = value;
		}
		
		
	}
}
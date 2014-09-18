package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Projtbl")]
	public class Projtbl
	{
		private var _id : Number;
		private var _name : String;
		private var _startd : Date;
		private var _endd : Date;
		
		private var _totbud : Number;
		private var _totbudClient : String;
		
		private var _budspend : Number;
		private var _budspendClient : String;
		
		private var _budAvailClient : String;
		
		private var _progtblid : Progtbl;
		private var _ndp : Number;
		private var _ndpitem : Number;
		private var _score : Number;
		private var _scoreClient : String;
		
		private var _allocatedBudget : String;
		private var _owner : Userepms;
		private var _errorCode : Number;
		private var _errorMessage : String;
		
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
		
		public function get startd():Date
		{
			return _startd;
		}
		
		public function set startd(value:Date):void
		{
			_startd = value;
		}
		
		public function get endd():Date
		{
			return _endd;
		}
		
		public function set endd(value:Date):void
		{
			_endd = value;
		}
		
		public function get totbud():Number
		{
			return _totbud;
		}
		
		public function set totbud(value:Number):void
		{
			_totbud = value;
		}
		
		public function get budspend():Number
		{
			return _budspend;
		}
		
		public function set budspend(value:Number):void
		{
			_budspend = value;
		}
		
		public function get progtblid():Progtbl
		{
			return _progtblid;
		}
		
		public function set progtblid(value:Progtbl):void
		{
			_progtblid = value;
		}

		public function get ndp():Number
		{
			return _ndp;
		}

		public function set ndp(value:Number):void
		{
			_ndp = value;
		}

		public function get ndpitem():Number
		{
			return _ndpitem;
		}

		public function set ndpitem(value:Number):void
		{
			_ndpitem = value;
		}

		public function get score():Number
		{
			return _score;
		}

		public function set score(value:Number):void
		{
			_score = value;
		}

		public function get scoreClient():String
		{
			return _scoreClient;
		}

		public function set scoreClient(value:String):void
		{
			_scoreClient = value;
		}

		public function get budspendClient():String
		{
			return _budspendClient;
		}

		public function set budspendClient(value:String):void
		{
			_budspendClient = value;
		}

		public function get totbudClient():String
		{
			return _totbudClient;
		}

		public function set totbudClient(value:String):void
		{
			_totbudClient = value;
		}

		public function get allocatedBudget():String
		{
			return _allocatedBudget;
		}

		public function set allocatedBudget(value:String):void
		{
			_allocatedBudget = value;
		}

		public function get owner():Userepms
		{
			return _owner;
		}

		public function set owner(value:Userepms):void
		{
			_owner = value;
		}

		public function get errorCode():Number
		{
			return _errorCode;
		}

		public function set errorCode(value:Number):void
		{
			_errorCode = value;
		}

		public function get errorMessage():String
		{
			return _errorMessage;
		}

		public function set errorMessage(value:String):void
		{
			_errorMessage = value;
		}

		public function get budAvailClient():String
		{
			return _budAvailClient;
		}

		public function set budAvailClient(value:String):void
		{
			_budAvailClient = value;
		}


	}
}
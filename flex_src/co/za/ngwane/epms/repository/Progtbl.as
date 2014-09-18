package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Progtbl")]
	public class Progtbl
	{
		private var _id : Number;
		private var _name : String;
		private var _sectionid : Sectiontbl;
		private var _description : String;
		
		private var _avbalance : Number;
		private var _avbalanceClient : String;
		
		private var _totalbudget : Number;
		private var _totalbudgetClient : String;
		
		private var _budspend : Number;
		private var _budspendClient : String;
		
		public function get totalbudget():Number
		{
			return _totalbudget;
		}
		
		public function set totalbudget(value:Number):void
		{
			_totalbudget = value;
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

		public function get sectionid():Sectiontbl
		{
			return _sectionid;
		}

		public function set sectionid(value:Sectiontbl):void
		{
			_sectionid = value;
		}

		public function get description():String
		{
			return _description;
		}

		public function set description(value:String):void
		{
			_description = value;
		}

		public function get avbalance():Number
		{
			return _avbalance;
		}

		public function set avbalance(value:Number):void
		{
			_avbalance = value;
		}

		public function get avbalanceClient():String
		{
			return _avbalanceClient;
		}

		public function set avbalanceClient(value:String):void
		{
			_avbalanceClient = value;
		}

		public function get totalbudgetClient():String
		{
			return _totalbudgetClient;
		}

		public function set totalbudgetClient(value:String):void
		{
			_totalbudgetClient = value;
		}

		public function get budspend():Number
		{
			return _budspend;
		}

		public function set budspend(value:Number):void
		{
			_budspend = value;
		}

		public function get budspendClient():String
		{
			return _budspendClient;
		}

		public function set budspendClient(value:String):void
		{
			_budspendClient = value;
		}


	}
}
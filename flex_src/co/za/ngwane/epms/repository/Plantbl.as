package co.za.ngwane.epms.repository
{
	import mx.collections.ArrayCollection;

	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Plantbl")]
	public class Plantbl
	{
		private var _id : Number;
		private var _name : String;
		private var _description : String;
		private var _startd : Date;
		private var _endd : Date;
		private var _q1startd : Date;
		private var _q1endd : Date;
		private var _q2startd : Date;
		private var _q2endd : Date;
		private var _q3startd : Date;
		private var _q3endd : Date;
		private var _q4startd : Date;
		private var _q4endd : Date;
		private var _currp : Boolean;
		private var _budget : Number;
		private var _budspend : Number;
		
		private var _budgetClient : String;
		private var _budspendClient : String;
		
		private var _progtblCollection : ArrayCollection;
		
		public function Plantbl()
		{
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

		public function get description():String
		{
			return _description;
		}

		public function set description(value:String):void
		{
			_description = value;
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

		public function get q1startd():Date
		{
			return _q1startd;
		}

		public function set q1startd(value:Date):void
		{
			_q1startd = value;
		}

		public function get q1endd():Date
		{
			return _q1endd;
		}

		public function set q1endd(value:Date):void
		{
			_q1endd = value;
		}

		public function get q2startd():Date
		{
			return _q2startd;
		}

		public function set q2startd(value:Date):void
		{
			_q2startd = value;
		}

		public function get q2endd():Date
		{
			return _q2endd;
		}

		public function set q2endd(value:Date):void
		{
			_q2endd = value;
		}

		public function get q3startd():Date
		{
			return _q3startd;
		}

		public function set q3startd(value:Date):void
		{
			_q3startd = value;
		}

		public function get q3endd():Date
		{
			return _q3endd;
		}

		public function set q3endd(value:Date):void
		{
			_q3endd = value;
		}

		public function get q4startd():Date
		{
			return _q4startd;
		}

		public function set q4startd(value:Date):void
		{
			_q4startd = value;
		}

		public function get q4endd():Date
		{
			return _q4endd;
		}

		public function set q4endd(value:Date):void
		{
			_q4endd = value;
		}

		public function get currp():Boolean
		{
			return _currp;
		}

		public function set currp(value:Boolean):void
		{
			_currp = value;
		}

		public function get progtblCollection():ArrayCollection
		{
			return _progtblCollection;
		}

		public function set progtblCollection(value:ArrayCollection):void
		{
			_progtblCollection = value;
		}

		public function get budspend():Number
		{
			return _budspend;
		}

		public function set budspend(value:Number):void
		{
			_budspend = value;
		}

		public function get budget():Number
		{
			return _budget;
		}

		public function set budget(value:Number):void
		{
			_budget = value;
		}

		public function get budspendClient():String
		{
			return _budspendClient;
		}

		public function set budspendClient(value:String):void
		{
			_budspendClient = value;
		}

		public function get budgetClient():String
		{
			return _budgetClient;
		}

		public function set budgetClient(value:String):void
		{
			_budgetClient = value;
		}


	}
}
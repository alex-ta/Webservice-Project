package dao;

import data.Template;

public class TemplateDao extends Dao<Template>{

	@Override
	Class<Template> getDaoClass() {
		return Template.class;
	}

	@Override
	Template setPrimaryKey(Template o) {
		return o;
	}
	
}

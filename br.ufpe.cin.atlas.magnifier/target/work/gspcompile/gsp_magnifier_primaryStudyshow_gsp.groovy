import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_primaryStudyshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/primaryStudy/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'primaryStudy.label', default: 'PrimaryStudy'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (primaryStudyInstance?.observation)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("primaryStudy.observation.label"),'default':("Observation")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(primaryStudyInstance),'field':("observation")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.mechanisms)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("primaryStudy.mechanisms.label"),'default':("Mechanisms")],-1)
printHtmlPart(19)
for( m in (primaryStudyInstance.mechanisms) ) {
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("associationMechanism"),'action':("show"),'id':(m.id)],4)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.authors)) {
printHtmlPart(23)
invokeTag('message','g',48,['code':("primaryStudy.authors.label"),'default':("Authors")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',50,['bean':(primaryStudyInstance),'field':("authors")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.conferenceSource)) {
printHtmlPart(25)
invokeTag('message','g',57,['code':("primaryStudy.conferenceSource.label"),'default':("Conference Source")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',59,['bean':(primaryStudyInstance),'field':("conferenceSource")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.intituitions)) {
printHtmlPart(27)
invokeTag('message','g',66,['code':("primaryStudy.intituitions.label"),'default':("Intituitions")],-1)
printHtmlPart(19)
for( i in (primaryStudyInstance.intituitions) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(i?.encodeAsHTML())
})
invokeTag('link','g',69,['controller':("institution"),'action':("show"),'id':(i.id)],4)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.studyId)) {
printHtmlPart(29)
invokeTag('message','g',77,['code':("primaryStudy.studyId.label"),'default':("Study Id")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',79,['bean':(primaryStudyInstance),'field':("studyId")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.studyTypes)) {
printHtmlPart(31)
invokeTag('message','g',86,['code':("primaryStudy.studyTypes.label"),'default':("Study Types")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',88,['bean':(primaryStudyInstance),'field':("studyTypes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.title)) {
printHtmlPart(33)
invokeTag('message','g',95,['code':("primaryStudy.title.label"),'default':("Title")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',97,['bean':(primaryStudyInstance),'field':("title")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (primaryStudyInstance?.year)) {
printHtmlPart(35)
invokeTag('message','g',104,['code':("primaryStudy.year.label"),'default':("Year")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',106,['bean':(primaryStudyInstance),'field':("year")],-1)
printHtmlPart(16)
}
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',114,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',114,['class':("edit"),'action':("edit"),'resource':(primaryStudyInstance)],3)
printHtmlPart(39)
invokeTag('actionSubmit','g',115,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(40)
})
invokeTag('form','g',117,['url':([resource:primaryStudyInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',119,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385152033000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

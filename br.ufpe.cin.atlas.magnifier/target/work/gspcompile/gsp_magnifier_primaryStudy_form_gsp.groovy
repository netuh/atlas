import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_primaryStudy_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/primaryStudy/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'observation', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("primaryStudy.observation.label"),'default':("Observation")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("observation"),'value':(primaryStudyInstance?.observation)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'mechanisms', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("primaryStudy.mechanisms.label"),'default':("Mechanisms")],-1)
printHtmlPart(5)
for( m in (primaryStudyInstance?.mechanisms) ) {
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',21,['controller':("associationMechanism"),'action':("show"),'id':(m.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'associationMechanism.label', default: 'AssociationMechanism')]))
})
invokeTag('link','g',24,['controller':("associationMechanism"),'action':("create"),'params':(['primaryStudy.id': primaryStudyInstance?.id])],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'authors', 'error'))
printHtmlPart(10)
invokeTag('message','g',32,['code':("primaryStudy.authors.label"),'default':("Authors")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'conferenceSource', 'error'))
printHtmlPart(12)
invokeTag('message','g',40,['code':("primaryStudy.conferenceSource.label"),'default':("Conference Source")],-1)
printHtmlPart(2)
invokeTag('textField','g',43,['name':("conferenceSource"),'value':(primaryStudyInstance?.conferenceSource)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'intituitions', 'error'))
printHtmlPart(13)
invokeTag('message','g',48,['code':("primaryStudy.intituitions.label"),'default':("Intituitions")],-1)
printHtmlPart(2)
invokeTag('select','g',51,['name':("intituitions"),'from':(br.ufpe.cin.atlas.magnifier.Institution.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(primaryStudyInstance?.intituitions*.id),'class':("many-to-many")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'studyId', 'error'))
printHtmlPart(14)
invokeTag('message','g',56,['code':("primaryStudy.studyId.label"),'default':("Study Id")],-1)
printHtmlPart(2)
invokeTag('textField','g',59,['name':("studyId"),'value':(primaryStudyInstance?.studyId)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'studyTypes', 'error'))
printHtmlPart(15)
invokeTag('message','g',64,['code':("primaryStudy.studyTypes.label"),'default':("Study Types")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'title', 'error'))
printHtmlPart(16)
invokeTag('message','g',72,['code':("primaryStudy.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',75,['name':("title"),'value':(primaryStudyInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: primaryStudyInstance, field: 'year', 'error'))
printHtmlPart(17)
invokeTag('message','g',80,['code':("primaryStudy.year.label"),'default':("Year")],-1)
printHtmlPart(18)
invokeTag('field','g',83,['name':("year"),'type':("number"),'value':(primaryStudyInstance.year),'required':("")],-1)
printHtmlPart(19)
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

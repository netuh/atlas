package br.ufpe.cin.atlas.magnifier



import grails.test.mixin.*
import spock.lang.*

@TestFor(SourceInstitutionController)
@Mock(SourceInstitution)
class SourceInstitutionControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.sourceInstitutionInstanceList
            model.sourceInstitutionInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.sourceInstitutionInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def sourceInstitution = new SourceInstitution()
            sourceInstitution.validate()
            controller.save(sourceInstitution)

        then:"The create view is rendered again with the correct model"
            model.sourceInstitutionInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            sourceInstitution = new SourceInstitution(params)

            controller.save(sourceInstitution)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/sourceInstitution/show/1'
            controller.flash.message != null
            SourceInstitution.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def sourceInstitution = new SourceInstitution(params)
            controller.show(sourceInstitution)

        then:"A model is populated containing the domain instance"
            model.sourceInstitutionInstance == sourceInstitution
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def sourceInstitution = new SourceInstitution(params)
            controller.edit(sourceInstitution)

        then:"A model is populated containing the domain instance"
            model.sourceInstitutionInstance == sourceInstitution
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/sourceInstitution/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def sourceInstitution = new SourceInstitution()
            sourceInstitution.validate()
            controller.update(sourceInstitution)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.sourceInstitutionInstance == sourceInstitution

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            sourceInstitution = new SourceInstitution(params).save(flush: true)
            controller.update(sourceInstitution)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/sourceInstitution/show/$sourceInstitution.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/sourceInstitution/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def sourceInstitution = new SourceInstitution(params).save(flush: true)

        then:"It exists"
            SourceInstitution.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(sourceInstitution)

        then:"The instance is deleted"
            SourceInstitution.count() == 0
            response.redirectedUrl == '/sourceInstitution/index'
            flash.message != null
    }
}

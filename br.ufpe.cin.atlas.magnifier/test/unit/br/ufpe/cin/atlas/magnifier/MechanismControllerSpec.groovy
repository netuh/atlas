package br.ufpe.cin.atlas.magnifier



import grails.test.mixin.*
import spock.lang.*

@TestFor(MechanismController)
@Mock(Mechanism)
class MechanismControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mechanismInstanceList
            model.mechanismInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mechanismInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def mechanism = new Mechanism()
            mechanism.validate()
            controller.save(mechanism)

        then:"The create view is rendered again with the correct model"
            model.mechanismInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mechanism = new Mechanism(params)

            controller.save(mechanism)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mechanism/show/1'
            controller.flash.message != null
            Mechanism.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mechanism = new Mechanism(params)
            controller.show(mechanism)

        then:"A model is populated containing the domain instance"
            model.mechanismInstance == mechanism
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mechanism = new Mechanism(params)
            controller.edit(mechanism)

        then:"A model is populated containing the domain instance"
            model.mechanismInstance == mechanism
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mechanism/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mechanism = new Mechanism()
            mechanism.validate()
            controller.update(mechanism)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mechanismInstance == mechanism

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mechanism = new Mechanism(params).save(flush: true)
            controller.update(mechanism)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/mechanism/show/$mechanism.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mechanism/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mechanism = new Mechanism(params).save(flush: true)

        then:"It exists"
            Mechanism.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mechanism)

        then:"The instance is deleted"
            Mechanism.count() == 0
            response.redirectedUrl == '/mechanism/index'
            flash.message != null
    }
}

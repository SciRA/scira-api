package scira.sparql.controller;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scira.sparql.vocabulary.SCHEMA;
import virtuoso.jena.driver.VirtGraph;

import java.time.LocalDate;
import java.util.function.Consumer;

/**
 * Created by SilviuG on 28.11.2017.
 */
@Component
public class VirtuosoController {

    @Autowired
    private VirtGraph virtGraph;

    public <T> void save(T entity) {
        Model model = ModelFactory.createDefaultModel();
        Resource article = model.createResource("http://example.org/paperId545");
/*        model.add(article, RDF.type, SCHEMA.ScholarlyArticle);
        model.add(article, SCHEMA.name, "Machine Learning article");
        model.add(article, SCHEMA.url, "https://fdsgasgdsf.com/article");
        model.add(article, SCHEMA.datePublished, LocalDate.now().toString());
        model.add(article, SCHEMA.author, "Liviu Ciortuz");
        model.add(article, SCHEMA.author, "Tom Mitchell");*/

        virtGraph.getTransactionHandler().begin();
        //virtGraph.clear();
        executeOperation(virtGraph::add, article, RDF.type, SCHEMA.ScholarlyArticle);
        executeOperation(virtGraph::add, article, SCHEMA.name, "Paper Classification");
        executeOperation(virtGraph::add, article, SCHEMA.url, "https://paper.com/classification");
        executeOperation(virtGraph::add, article, SCHEMA.datePublished, LocalDate.now());
        executeOperation(virtGraph::add, article, SCHEMA.author, "Andrew Smith");
        executeOperation(virtGraph::add, article, SCHEMA.inLanguage, NodeFactory.createLiteral("Romanian", XSDDatatype.XSDlanguage));
        //executeOperation(virtGraph::add, article, SCHEMA.author, "Tom Mitchell");
        virtGraph.getTransactionHandler().commit();
        System.out.println("commit Transaction.");
        System.out.println("graph.isEmpty() = " + virtGraph.isEmpty());
        System.out.println("graph.getCount() = " + virtGraph.getCount());

        ExtendedIterator iter = virtGraph.find(Node.ANY, Node.ANY, Node.ANY);
        System.out.println("\ngraph.find(Node.ANY, Node.ANY, Node.ANY) \nResult:");
        for (; iter.hasNext(); )
            System.out.println((Triple) iter.next());
    }

    private static void executeOperation(Consumer<Triple> consumer, Resource subject, Property predicate, Resource object) {
        consumer.accept(createTriple(subject, predicate, object));
    }

    private static void executeOperation(Consumer<Triple> consumer, Resource subject, Property predicate, LocalDate object) {
        consumer.accept(createTriple(subject, predicate, object));
    }

    private static void executeOperation(Consumer<Triple> consumer, Resource subject, Property predicate, String object) {
        consumer.accept(createTriple(subject, predicate, object));
    }

    private static void executeOperation(Consumer<Triple> consumer, Resource subject, Property predicate, Node object) {
        consumer.accept(createTriple(subject, predicate, object));
    }

    private static Triple createTriple(Resource subject, Property predicate, Resource object) {
        Node subjectNode = NodeFactory.createURI(subject.getURI());
        Node predicateNode = NodeFactory.createURI(predicate.getURI());
        Node objectNode = NodeFactory.createURI(object.getURI());
        return Triple.create(subjectNode, predicateNode, objectNode);
    }

    private static Triple createTriple(Resource subject, Property predicate, Node object) {
        Node subjectNode = NodeFactory.createURI(subject.getURI());
        Node predicateNode = NodeFactory.createURI(predicate.getURI());
        return Triple.create(subjectNode, predicateNode, object);
    }

    private static Triple createTriple(Resource subject, Property predicate, LocalDate object) {
        Node subjectNode = NodeFactory.createURI(subject.getURI());
        Node predicateNode = NodeFactory.createURI(predicate.getURI());
        Node objectNode = NodeFactory.createLiteral(object.toString(), XSDDatatype.XSDdate);
        return Triple.create(subjectNode, predicateNode, objectNode);
    }

    private static Triple createTriple(Resource subject, Property predicate, String object) {
        Node subjectNode = NodeFactory.createURI(subject.getURI());
        Node predicateNode = NodeFactory.createURI(predicate.getURI());
        Node objectNode = NodeFactory.createLiteral(object);
        return Triple.create(subjectNode, predicateNode, objectNode);
    }
}

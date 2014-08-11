package com.orbitz.consul;

import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.State;
import com.orbitz.consul.model.health.HealthCheck;
import com.orbitz.consul.model.health.ServiceHealth;
import com.orbitz.consul.query.QueryOptions;
import com.orbitz.consul.util.ClientUtil;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * HTTP Client for /v1/health/ endpoints.
 */
public class HealthClient {
    
    private WebTarget webTarget;

    /**
     * Constructs an instance of this class.
     *
     * @param webTarget The {@link javax.ws.rs.client.WebTarget} to base requests from.
     */
    HealthClient(WebTarget webTarget) {
        this.webTarget = webTarget;
    }

    /**
     * Retrieves the healthchecks for a node.
     *
     * GET /v1/health/node/{node}
     *
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getNodeChecks(String node) {
        return getNodeChecks(node, null, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for a node in a given datacenter.
     *
     * GET /v1/health/node/{node}?dc={datacenter}
     *
     * @param datacenter The datacenter to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getNodeChecks(String node, String datacenter) {
        return getNodeChecks(node, datacenter, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for a node with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/node/{node}
     *
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getNodeChecks(String node, QueryOptions queryOptions) {
        return getNodeChecks(node, null, queryOptions);
    }

    /**
     * Retrieves the healthchecks for a node in a given datacenter with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/node/{node}?dc={datacenter}
     *
     * @param datacenter The datacenter to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getNodeChecks(String node, String datacenter, QueryOptions queryOptions) {
        return ClientUtil.response(webTarget.path("node").path(node), datacenter, queryOptions,
                new GenericType<List<HealthCheck>>() {});
    }

    /**
     * Retrieves the healthchecks for a service.
     *
     * GET /v1/health/service/{service}
     *
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getServiceChecks(String service) {
        return getNodeChecks(service, null, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for a service in a given datacenter.
     *
     * GET /v1/health/service/{service}?dc={datacenter}
     *
     * @param datacenter The datacenter to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getServiceChecks(String service, String datacenter) {
        return getNodeChecks(service, datacenter, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for a service with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/service/{service}
     *
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getServiceChecks(String service, QueryOptions queryOptions) {
        return getNodeChecks(service, null, queryOptions);
    }

    /**
     * Retrieves the healthchecks for a service in a given datacenter with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/service/{service}?dc={datacenter}
     *
     * @param datacenter The datacenter to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getServiceChecks(String service, String datacenter,
                                                              QueryOptions queryOptions) {
        return ClientUtil.response(webTarget.path("checks").path(service), datacenter, queryOptions,
                new GenericType<List<HealthCheck>>() {});
    }

    /**
     * Retrieves the healthchecks for a state.
     *
     * GET /v1/health/state/{state}
     *
     * @param state The state to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getChecksByState(State state) {
        return getChecksByState(state, null, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for a state in a given datacenter.
     *
     * GET /v1/health/state/{state}?dc={datacenter}
     *
     * @param state The state to query.
     * @param datacenter The datacenter to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getChecksByState(State state, String datacenter) {
        return getChecksByState(state, datacenter, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for a state with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/state/{state}
     *
     * @param state The state to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getChecksByState(State state, QueryOptions queryOptions) {
        return getChecksByState(state, null, queryOptions);
    }

    /**
     * Retrieves the healthchecks for a state in a given datacenter with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/state/{state}?dc={datacenter}
     *
     * @param state The state to query.
     * @param datacenter The datacenter to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<HealthCheck>> getChecksByState(State state, String datacenter,
                                                              QueryOptions queryOptions) {
        return ClientUtil.response(webTarget.path("state").path(state.getPath()), datacenter, queryOptions,
                new GenericType<List<HealthCheck>>() {});
    }

    /**
     * Retrieves the healthchecks for all healthy nodes.
     *
     * GET /v1/health/service/{service}?passing
     *
     * @param service The service to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getHealthyNodes(String service) {
        return getHealthyNodes(service, null, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for all healthy nodes in a given datacenter.
     *
     * GET /v1/health/service/{service}?dc={datacenter}&passing
     *
     * @param service The service to query.
     * @param datacenter The datacenter to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getHealthyNodes(String service, String datacenter) {
        return getHealthyNodes(service, datacenter, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for all healthy nodes with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/service/{service}?passing
     *
     * @param service The service to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getHealthyNodes(String service, QueryOptions queryOptions) {
        return getHealthyNodes(service, null, queryOptions);
    }

    /**
     * Retrieves the healthchecks for all healthy nodes in a given datacenter with
     * {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/service/{service}?dc={datacenter}&passing
     *
     * @param service The service to query.
     * @param datacenter The datacenter to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getHealthyNodes(String service, String datacenter,
                                                               QueryOptions queryOptions) {
        return ClientUtil.response(webTarget.path("service").path(service).queryParam("passing", "true"),
                datacenter, queryOptions, new GenericType<List<ServiceHealth>>() {});
    }

    /**
     * Retrieves the healthchecks for all nodes.
     *
     * GET /v1/health/service/{service}
     *
     * @param service The service to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getAllNodes(String service) {
        return getAllNodes(service, null, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for all nodes in a given datacenter.
     *
     * GET /v1/health/service/{service}?dc={datacenter}
     *
     * @param service The service to query.
     * @param datacenter The datacenter to query.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getAllNodes(String service, String datacenter) {
        return getAllNodes(service, datacenter, QueryOptions.BLANK);
    }

    /**
     * Retrieves the healthchecks for all nodes with {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/service/{service}
     *
     * @param service The service to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getAllNodes(String service, QueryOptions queryOptions) {
        return getAllNodes(service, null, queryOptions);
    }

    /**
     * Retrieves the healthchecks for all nodes in a given datacenter with
     * {@link com.orbitz.consul.query.QueryOptions}.
     *
     * GET /v1/health/service/{service}?dc={datacenter}
     *
     * @param service The service to query.
     * @param datacenter The datacenter to query.
     * @param queryOptions The Query Options to use.
     * @return A {@link com.orbitz.consul.model.ConsulResponse} containing a list of
     * {@link com.orbitz.consul.model.health.HealthCheck} objects.
     */
    public ConsulResponse<List<ServiceHealth>> getAllNodes(String service, String datacenter,
                                                               QueryOptions queryOptions) {
        return ClientUtil.response(webTarget.path("service").path(service), datacenter, queryOptions,
                new GenericType<List<ServiceHealth>>() {});
    }
}
